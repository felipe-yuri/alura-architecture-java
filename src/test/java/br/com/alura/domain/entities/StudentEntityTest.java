package br.com.alura.domain.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.alura.entities.CPF;
import br.com.alura.entities.Email;
import br.com.alura.entities.StudentEntity;

class StudentEntityTest {
	private static StudentEntity student;
	private static CPF cpf;
	private static Email email;
	
	@BeforeAll
	static void init() {
		cpf = new CPF("000.000.000-00");
		email = new Email("felipe@gmail.com");
		student = new StudentEntity(cpf, "felipe", email);
	}
	

	@Test
	void addPhonesTest() {
		student.addPhones("34", "991312001");
		student.addPhones("34", "991582752");
		assertEquals(student.getPhones().get(0).getDdd(),"34");
		assertEquals(student.getPhones().get(0).getNumber(),"991312001");
		assertEquals(student.getPhones().get(1).getDdd(),"34");
		assertEquals(student.getPhones().get(1).getNumber(),"991582752");
	}
	
	@Test
	void getCpfTest() {
		assertEquals(cpf.getCPF(), "000.000.000-00");
	}
	
	@Test
	void getNameTest() {
		assertEquals(student.getName(), "felipe");
	}
	
	@Test
	void getEmailTest() {
		assertEquals(email.getEmail(), "felipe@gmail.com");
	}

}
