package br.com.alura.domain.entities.student;

public class StudentEntityBuilder {

	private StudentEntity student;
	
	public StudentEntityBuilder() {
		this.student = new StudentEntity(null, null, null);
	}

	public StudentEntityBuilder buildWithNameCpfEmail(String name, String cpf, String email) {
		this.student = new StudentEntity(new CPF(cpf), name, new Email(email));
		return this;
	}

	public StudentEntityBuilder setPhone(String ddd, String number) {
		this.student.addPhones(ddd, number);
		return this;
	}
	
	public StudentEntity create() {
		return this.student;
	}
}
