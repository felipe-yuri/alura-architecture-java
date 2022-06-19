package br.com.alura.domain.repositories;

import java.util.List;

import br.com.alura.domain.entities.student.CPF;
import br.com.alura.domain.entities.student.StudentEntity;

public interface StudentRepository {
	
	void enroll(StudentEntity student);
	StudentEntity searchByCpf(CPF cpf);
	List<StudentEntity> searchAll();

}
