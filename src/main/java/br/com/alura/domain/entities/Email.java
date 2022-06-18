package br.com.alura.domain.entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
	private String email;

	public Email(String email) {
		if (email == null || email.isBlank() || validateAfterAt(email) || !validateSpecialCharacter(email)) {
			throw new IllegalArgumentException("This is not a valid email!");
		}
		this.email = email;
	}

	private boolean validateAfterAt(String email) {
		int index = email.indexOf('@');
		int size = email.length();
		if (size > 1 && index >= 0) {
			return email.substring(index, size - 1).isEmpty() || email.substring(0, index).isEmpty();
		}
		return true;
	}

	private boolean validateSpecialCharacter(String email) {
		final String REGEX = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		Matcher m = Pattern.compile(REGEX).matcher(email);
		return m.find();
	}

	public String getEmail() {
		return email;
	}
}
