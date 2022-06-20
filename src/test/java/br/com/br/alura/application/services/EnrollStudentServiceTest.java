package br.com.br.alura.application.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.alura.application.services.EnrollStudentDTO;
import br.com.alura.application.services.EnrollStudentService;
import br.com.alura.domain.entities.student.CPF;
import br.com.alura.domain.entities.student.StudentEntity;
import br.com.alura.infra.repositories.StudentRepositoryInMemory;

public class EnrollStudentServiceTest {

	@Test
	void executeTest() {
		StudentRepositoryInMemory repository = new StudentRepositoryInMemory();
		EnrollStudentService enroll = new EnrollStudentService(repository);
		EnrollStudentDTO dto = new EnrollStudentDTO("abc", "000.000.000-00", "abc@gmail.com");
		enroll.execute(dto);
		
		StudentEntity studentFounded = repository.searchByCpf(new CPF("000.000.000-00"));
		assertEquals(studentFounded.getName(), dto.getStudentName());
		assertEquals(studentFounded.getCpf(), dto.getStudentCpf());
		assertEquals(studentFounded.getEmail(), dto.getStudentEmail());
		
	}

}
