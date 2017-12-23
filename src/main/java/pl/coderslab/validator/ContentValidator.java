package pl.coderslab.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContentValidator implements ConstraintValidator<Content, String> {
	private int minLength;

	@Override
	public void initialize(Content constraintAnnotation) {
		this.minLength = constraintAnnotation.minLength();
	}

	@Override
	public boolean isValid(String text, ConstraintValidatorContext context) {
		return text.length() > minLength;
	}

}
