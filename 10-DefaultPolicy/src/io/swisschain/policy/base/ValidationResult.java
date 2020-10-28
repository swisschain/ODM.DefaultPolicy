package io.swisschain.policy.base;

public class ValidationResult {
	private String validatedBy;
	private ValidationResolution resolution;
	public ValidationResult() {
	}
	public ValidationResult(String validatedBy, ValidationResolution resolution) {
		this.validatedBy = validatedBy;
		this.resolution = resolution;
	}
	public String getValidatedBy() {
		return validatedBy;
	}
	public void setValidatedBy(String validatedBy) {
		this.validatedBy = validatedBy;
	}
	public ValidationResolution getResolution() {
		return resolution;
	}
	public void setResolution(ValidationResolution resolution) {
		this.resolution = resolution;
	}
}
