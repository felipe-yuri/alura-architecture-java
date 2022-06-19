package br.com.alura.domain.entities.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class EmailTest {
	
	@Test
	void constructorTest() {
		assertThrows(IllegalArgumentException.class, () -> new Email(null));
		assertThrows(IllegalArgumentException.class, () -> new Email(""));
		assertThrows(IllegalArgumentException.class, () -> new Email("felipe@"));
		assertThrows(IllegalArgumentException.class, () -> new Email("@"));
		assertThrows(IllegalArgumentException.class, () -> new Email("felipe.yuri"));
		assertThrows(IllegalArgumentException.class, () -> new Email("@felipe.yuri"));
	}
	
	@Test
	void validateAfterAtTest() {
		assertEquals(new Email("felipe.yuri@sankhya.com.br").getEmail(), "felipe.yuri@sankhya.com.br");
	}
	
	@Test
	void getEmailTest() {
		assertEquals(new Email("felipe.yuri@sankhya.com.br").getEmail(), "felipe.yuri@sankhya.com.br");
	}
	
}
