package br.com.alura.domain.entities.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CPFTest {

	@Test
	void constructorTest() {
		assertThrows(IllegalArgumentException.class, () -> new CPF(null));
		assertThrows(IllegalArgumentException.class, () -> new CPF(""));
		assertThrows(IllegalArgumentException.class, () -> new CPF("069"));
		assertThrows(IllegalArgumentException.class, () -> new CPF("069.069"));
		assertThrows(IllegalArgumentException.class, () -> new CPF("069.069.069"));
		assertThrows(IllegalArgumentException.class, () -> new CPF("069.069.069-"));
		assertThrows(IllegalArgumentException.class, () -> new CPF("069.069.069-0"));
		assertThrows(IllegalArgumentException.class, () -> new CPF("069.06906901"));
		assertThrows(IllegalArgumentException.class, () -> new CPF("06906906901"));
	}
	
	@Test
	void validateCpfTest() {
		assertEquals(new CPF("069.069.069-01").getCPF(), "069.069.069-01");
	}

}
