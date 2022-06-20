package br.com.alura.application.services;

import br.com.alura.domain.entities.student.CPF;
import br.com.alura.domain.entities.student.Email;
import br.com.alura.domain.entities.student.StudentEntity;

public class EnrollStudentDTO {

	private String studentName;
	private String studentCpf;
	private String studentEmail;

	public EnrollStudentDTO(String studentName, String studentCpf, String studentEmail) {
		this.studentName = studentName;
		this.studentCpf = studentCpf;
		this.studentEmail = studentEmail;
	}

	public StudentEntity createStudent() {
		return new StudentEntity(new CPF(studentCpf), studentName, new Email(studentEmail));
	}

	public String getStudentName() {
		return studentName;
	}

	public String getStudentCpf() {
		return studentCpf;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

}
