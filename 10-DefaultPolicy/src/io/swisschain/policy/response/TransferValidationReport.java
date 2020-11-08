package io.swisschain.policy.response;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TransferValidationReport {
	List<TransferValidationResponse> responses = new LinkedList<>();

	public TransferValidationReport() {
		
	}
	
	public void registerResponse(TransferValidationResponse response) {
		responses.add(response);
	}
	
	public TransferValidationResponse summarize() { 
		TransferValidationResponse result = new TransferValidationResponse();
		List<String> listOfValidators = new LinkedList<>();
		responses.forEach( response -> {
			listOfValidators.addAll(response.getNotifyValidators());
			if (response.getResolution() == TransferValidationResult.Decline) {
				result.setResolution(TransferValidationResult.Decline);
				result.setComment("Rejected vy validators");
			} else if (response.getResolution() == TransferValidationResult.Wait) {
				if (result.getResolution() != TransferValidationResult.Decline) {
					result.setResolution(TransferValidationResult.Wait);
				}
			} else if (response.getResolution() == TransferValidationResult.Approve) {
				if (result.getResolution() == null) {
					result.setResolution(TransferValidationResult.Approve);
				}
			}
		});
		
		if (result.getResolution() == null) {
			result.setResolution(TransferValidationResult.Decline);
			return result;
		}
		
		if (result.getResolution() == TransferValidationResult.Wait) {
			result.setNotifyValidators(listOfValidators.stream().distinct().collect(Collectors.toList()));
		}
		
		return result;
	}
}
