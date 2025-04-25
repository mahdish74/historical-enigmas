package com.historicalenigmas.enigma.core.machine

import com.historicalenigmas.enigma.core.machine.EnigmaI
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class EnigmaITest {

    @Test
    fun when_setAAForInputWithDefaultEnigmaSetting_then_getFT() {
        val enigmaI = EnigmaI()
        val expected = "FT"
        val actual = enigmaI.enCode("AA")
        assertEquals(expected, actual)
    }

    @Test
    fun when_setFTForInputWithDefaultEnigmaSetting_then_getAA() {
        val enigmaI = EnigmaI()
        val expected = "AA"
        val actual = enigmaI.enCode("FT")
        assertEquals(expected, actual)
    }

    @Test
    fun when_setLowerCaseCharForInputWithDefaultEnigmaSetting_then_IgnoreCharCaseAndEncodeIt() {
        val enigmaI = EnigmaI()
        val expected = "AA"
        val actual = enigmaI.enCode("ft")
        assertEquals(expected, actual)
    }

    @Test
    fun when_setInvalidCharForInput_then_throwIllegalArgumentException() {
        val enigmaI = EnigmaI()
        assertThrows(IllegalArgumentException::class.java) { enigmaI.enCode("*") }
    }


}