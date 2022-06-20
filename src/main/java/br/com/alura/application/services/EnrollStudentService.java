package br.com.alura.application.services;

import br.com.alura.domain.entities.student.StudentEntity;
import br.com.alura.domain.repositories.StudentRepository;

public class EnrollStudentService {

	private final StudentRepository repository;

	public EnrollStudentService(StudentRepository repository) {
		this.repository = repository;
	}

	public void execute(EnrollStudentDTO dto) {
		StudentEntity newStudent = dto.createStudent();
		repository.enroll(newStudent);
	}

}
