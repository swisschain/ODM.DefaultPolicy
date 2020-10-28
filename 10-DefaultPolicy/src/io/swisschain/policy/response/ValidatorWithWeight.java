package io.swisschain.policy.response;

public class ValidatorWithWeight {
	private Validator validator;
	private Integer weight;
	
	public ValidatorWithWeight(Validator validator, Integer weight) {
		super();
		this.validator = validator;
		this.weight = weight;
	}
	
	public Validator getValidator() {
		return validator;
	}
	public Integer getWeight() {
		return weight;
	}
	
	public static ValidatorWithWeight create(Validator validator, Integer weight)  {
		return new ValidatorWithWeight(validator, weight);
	}
}
