package br.com.alura.domain.services;

public interface EncondePasswordService {
	
	String encodePass(String pass);
	boolean validatePass(String encodedPass, String pass);
}
