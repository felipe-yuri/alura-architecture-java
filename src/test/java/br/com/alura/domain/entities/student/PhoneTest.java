package br.com.alura.domain.entities.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PhoneTest {
	private Phone phone = new Phone("34", "991312001");

	@Test
	void constructorTest() {
		assertThrows(IllegalArgumentException.class, () -> new Phone(null, null));
		assertThrows(IllegalArgumentException.class, () -> new Phone("", null));
		assertThrows(IllegalArgumentException.class, () -> new Phone("0", null));
		assertThrows(IllegalArgumentException.class, () -> new Phone("00", null));
		assertThrows(IllegalArgumentException.class, () -> new Phone("000", null));
		assertThrows(IllegalArgumentException.class, () -> new Phone("a", null));
		assertThrows(IllegalArgumentException.class, () -> new Phone("aa", null));
		assertThrows(IllegalArgumentException.class, () -> new Phone("aaa", null));
		assertThrows(IllegalArgumentException.class, () -> new Phone(null, ""));
		assertThrows(IllegalArgumentException.class, () -> new Phone(null, "1234567"));
		assertThrows(IllegalArgumentException.class, () -> new Phone(null, "12345678"));
		assertThrows(IllegalArgumentException.class, () -> new Phone(null, "123456789"));
		assertThrows(IllegalArgumentException.class, () -> new Phone(null, "12345678910"));
		assertThrows(IllegalArgumentException.class, () -> new Phone(null, "abcdefg"));
		assertThrows(IllegalArgumentException.class, () -> new Phone(null, "abcdefgh"));
		assertThrows(IllegalArgumentException.class, () -> new Phone(null, "abcdefghi"));
		assertThrows(IllegalArgumentException.class, () -> new Phone(null, "abcdefghij"));
		assertThrows(IllegalArgumentException.class, () -> new Phone("", ""));
	}
	
	@Test
	void validateNumberTest() {
		assertEquals(phone.getNumber(), "991312001");
	}
	
	@Test
	void validateDddTest() {
		assertEquals(phone.getDdd(), "34");
	}

}
