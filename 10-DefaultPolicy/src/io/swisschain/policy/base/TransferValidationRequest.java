package io.swisschain.policy.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import io.swisschain.policy.response.TransferValidationResponse;
import io.swisschain.policy.response.TransferValidationResult;
import io.swisschain.policy.response.ValidatorWithWeight;

public class TransferValidationRequest {
	private TransferDetails transferDetails;
	private List<ValidationResult> validatedBy = new ArrayList<>();	
	public TransferValidationRequest() {
	}
	public TransferValidationRequest(TransferDetails transferDetails, List<ValidationResult> validatedBy) {
		super();
		this.transferDetails = transferDetails;
		this.validatedBy = validatedBy;
	}
	public TransferDetails getTransferDetails() {
		return transferDetails;
	}
	public void setTransferDetails(TransferDetails transferDetails) {
		this.transferDetails = transferDetails;
	}
	public List<ValidationResult> getValidatedBy() {
		return validatedBy;
	}
	public void setValidatedBy(List<ValidationResult> validatedBy) {
		this.validatedBy = validatedBy;
	}
	
	public TransferValidationResponse checkValidators(Integer minScore, List<ValidatorWithWeight> requiredValidators) {
		TransferValidationResponse response = new TransferValidationResponse();
		Integer score = 0;
		for (ValidatorWithWeight validator : requiredValidators) {
			response.addValidator(validator.getValidator());
			Optional<ValidationResult> validated = validatedBy.stream().filter(it -> it.getValidatedBy().equals(validator.getValidator().getId())).findFirst();
			if (validated.isPresent()) {
				switch (validated.get().getResolution()) {
				case Approved:
					score += validator.getWeight();
					break;
				case Rejected:
					response.setResolution(TransferValidationResult.Decline);
					response.setComment("Rejected by validators ");
					return response;
				default:
					break;
				}
			}
		}		
		
		if (score >= minScore) {
			response.setResolution(TransferValidationResult.Approve);
			response.setComment("Fully approved with score " + score);
		} else {
			response.setResolution(TransferValidationResult.Wait);
			response.setComment("Min score " + minScore + ", actual score " + score);
		}
		
		return response;
	}
}
