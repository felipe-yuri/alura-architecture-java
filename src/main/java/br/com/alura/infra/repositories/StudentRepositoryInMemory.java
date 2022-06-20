package br.com.alura.infra.repositories;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.domain.entities.student.CPF;
import br.com.alura.domain.entities.student.StudentEntity;
import br.com.alura.domain.repositories.StudentRepository;

public class StudentRepositoryInMemory implements StudentRepository {
	
	private List<StudentEntity> enrolleds = new ArrayList<>();

	@Override
	public void enroll(StudentEntity student) {
		this.enrolleds.add(student);
	}

	@Override
	public StudentEntity searchByCpf(CPF cpf) {
		return this.enrolleds.stream()
				.filter(s -> s.getCpf().equals(cpf.getCPF()))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("Student not found for " + cpf));
	}

	@Override
	public List<StudentEntity> searchAll() {
		return this.enrolleds;
	}

}
