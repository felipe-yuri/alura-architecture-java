package br.com.alura.entities;

public class CPF {
	private String cpf;

	public CPF(String cpf) {
		if(cpf == null || !validateCpf(cpf)) {
			throw new IllegalArgumentException("CPF invalid!");
		}
		this.cpf = cpf;
	}
	
	private boolean validateCpf(String cpf) {
		final String REGEX = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}";
		return cpf.matches(REGEX);
	}
	
	public String getCPF() {
		return cpf;
	}
}
