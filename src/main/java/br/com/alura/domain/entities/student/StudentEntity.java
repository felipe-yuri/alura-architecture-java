package br.com.alura.domain.entities.student;

import java.util.ArrayList;
import java.util.List;

public class StudentEntity {
	private CPF cpf;
	private String name;
	private Email email;
	private String password;
	private List<Phone> phones = new ArrayList<>();
	
	public StudentEntity(CPF cpf, String name, Email email) {
		this.cpf = cpf;
		this.name = name;
		this.email = email;
	}

	public void addPhones(String ddd, String number) {
		this.phones.add(new Phone(ddd, number));
	}
	
	public List<Phone> getPhones() {
		return phones;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCpf() {
		return cpf.getCPF();
	}
	
	public String getEmail() {
		return email.getEmail();
	}
}
