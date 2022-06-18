package br.com.alura.domain.entities;

public class Phone {

	private String ddd;
	private String number;

	public Phone(String ddd, String number) {
		if (ddd == null || !validateDdd(ddd)) {
			throw new IllegalArgumentException("This ddd is invalid!");
		}
		if (number == null || !validateNumber(number)) {
			throw new IllegalArgumentException("This number is invalid!");
		}
		this.ddd = ddd;
		this.number = number;
	}

	private boolean validateNumber(String number) {
		return number.matches("\\d{8,9}");
	}

	private boolean validateDdd(String ddd) {
		return ddd.matches("\\d{2}");
	}

	public String getDdd() {
		return ddd;
	}

	public String getNumber() {
		return number;
	}
	
}
