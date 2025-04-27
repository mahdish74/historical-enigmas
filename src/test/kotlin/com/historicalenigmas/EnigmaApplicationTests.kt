package com.historicalenigmas

import com.historicalenigmas.enigma.core.machine.EnigmaI
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.assertThrows


@SpringBootTest
class EnigmaApplicationTests {


	private val enigma = EnigmaI()

	@Test
	fun `should encode valid uppercase input`() {
		val result = enigma.enCode("HELLO")
		assertEquals(5, result.length)
	}

	@Test
	fun `should encode valid lowercase input`() {
		val result = enigma.enCode("hello")
		assertEquals(5, result.length)
	}

	@Test
	fun `should encode input containing hyphens`() {
		val result = enigma.enCode("HELLOWORLD")
		assertEquals(10, result.length)
	}

	@Test
	fun `should throw exception for input containing numbers`() {
		assertThrows<IllegalArgumentException> {
			enigma.enCode("HELLO123")
		}
	}

	@Test
	fun `should throw exception for input containing special characters`() {
		assertThrows<IllegalArgumentException> {
			enigma.enCode("HELLO@WORLD")
		}
	}

	@Test
	fun `should throw exception for empty string`() {
		assertThrows<IllegalArgumentException> {
			enigma.enCode("")
		}
	}

	@Test
	fun `output should have same length as input`() {
		val input = "ENIGMA"
		val output = enigma.enCode(input)
		assertEquals(input.length, output.length)
	}

	@Test
	fun `encoding twice should return the original input`() {
		val input = "SECRET"
		val encoded = enigma.enCode(input)
		val reEncoded = enigma.enCode(encoded)
		assertEquals(input.uppercase(), reEncoded)
	}

	@Test
	fun `should rotate rotors after 26 characters`() {
		val input = "A".repeat(26) // AAAAAAAAAAAAAAAAAAAAAAAAAA
		val output = enigma.enCode(input)
		assertEquals(26, output.length)
	}

	@Test
	fun `should rotate second rotor after 26 characters`() {
		val enigmaTest = EnigmaI()
		val firstEncoding = enigmaTest.enCode("A".repeat(25)) // Rotor II shouldn't move yet
		val secondEncoding = enigmaTest.enCode("A".repeat(1)) // Rotor II should rotate once
		assertEquals(25, firstEncoding.length)
		assertEquals(1, secondEncoding.length)
	}

}
