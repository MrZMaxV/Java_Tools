package ua.com.foxminded.reverse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReverseTest {

	@Test
	void testHelloWorld() {
		assertEquals("olleH dlroW", Reverse.reverse("Hello World"));
	}

	@Test
	void testEmptyString() {
		assertEquals("", Reverse.reverse(""));
	}
	
	@Test
	void testOneSymbol() {
		assertEquals("H", Reverse.reverse("H"));
	}
	
	@Test
	void testWordTwoSymbols() {
		assertEquals("Ar", Reverse.reverse("rA"));
	}
	
	@Test
	void testFewSpace() {
		assertEquals("olleH yM dlroW", Reverse.reverse("Hello My World"));
	}
	
}
