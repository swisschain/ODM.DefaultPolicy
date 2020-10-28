package io.swisschain.policy.response;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransferValidationResponse {
	private TransferValidationResult resolution;
	private List<String> notifyValidators = new ArrayList<>();
	private String comment;
	
	public TransferValidationResponse() {
		super();
	}	
	
	public TransferValidationResponse(TransferValidationResult resolution) {
		super();
		this.resolution = resolution;
	}

	public TransferValidationResponse(TransferValidationResult resolution, String comment) {
		super();
		this.resolution = resolution;
		this.comment = comment;
	}

	public TransferValidationResult getResolution() {
		return resolution;
	}
	public void setResolution(TransferValidationResult resolution) {
		this.resolution = resolution;
	}
	public List<String> getNotifyValidators() {
		return notifyValidators;
	}
	public void setNotifyValidators(List<String> notifyValidators) {
		this.notifyValidators = notifyValidators;
	}
	public void addValidator(Validator validator) {
		notifyValidators.add(validator.getId());
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}		
	public String toString() {
		return "Resolution: " + resolution + "; comment: " + comment + "; number of validators: " + notifyValidators.size() + 
				"; validators: " + notifyValidators.stream().collect(Collectors.toList());
	}
	
}
