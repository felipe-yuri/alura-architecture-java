package br.com.alura.infra.services;

import java.security.MessageDigest;

import br.com.alura.domain.services.EncondePasswordService;

public class EncondePassMD5Service implements EncondePasswordService {

	@Override
	public String encodePass(String pass) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(pass.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		} catch (Exception e) {
			throw new RuntimeException("Error to generate hash!");
		}
	}

	@Override
	public boolean validatePass(String encodedPass, String pass) {
		return encodedPass.equals(encodePass(pass));
	}

}
