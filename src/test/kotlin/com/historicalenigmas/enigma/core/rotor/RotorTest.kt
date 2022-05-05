package com.historicalenigmas.enigma.core.rotor

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import java.util.*
import kotlin.properties.Delegates

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RotorTest {

    private lateinit var list: MutableList<String>
    private var lastIndexOfAlfabetList by Delegates.notNull<Int>()

    @BeforeAll
    fun setUp() {

        list = Arrays.asList(
            "a",
            "b",
            "c",
            "d",
            "e",
            "f",
            "g",
            "h",
            "i",
            "j",
            "k",
            "l",
            "m",
            "n",
            "o",
            "p",
            "q",
            "r",
            "s",
            "t",
            "u",
            "v",
            "w",
            "x",
            "y",
            "z"
        )
       lastIndexOfAlfabetList = list.size - 1
    }

    @Test
    fun when_callGetAlfabetWithZiroInputForFirstTimeFromRotorWithPositionZero_Then_getFirstCharInList() {
        val posiyion = 0
        val rotorI = Rotor(list.toMutableList(), posiyion)
        val expected = "a"
        val actual = rotorI.getAlfabet(0)
        assertEquals(expected, actual)
    }

    @Test
    fun when_callGetAlfabetWithZiroInputForSecondTimeFromRotorWithPositionZero_Then_getSecondCharInList() {
        val posiyion = 0
        val rotorI = Rotor(list.toMutableList(), posiyion)
        val expected = "b"
        rotorI.getAlfabet(0)
        val actual = rotorI.getAlfabet(0)
        assertEquals(expected, actual)
    }

    @Test
    fun when_callGetAlfabetWithThreeInputForFirstFromRotorWithPositionZero_Then_getFourthCharInList() {
        val posiyion = 0
        val rotorI = Rotor(list.toMutableList(), posiyion)
        val expected = "d"
        val actual = rotorI.getAlfabet(3)
        assertEquals(expected, actual)
    }

    @Test
    fun when_callGetAlfabetWithThreeInputForSecondTimeFromRotorWithPositionZero_Then_getFifthCharInList() {
        val posiyion = 0
        val rotorI = Rotor(list.toMutableList(), posiyion)
        var expected = "e"
        rotorI.getAlfabet(3)
        val actual = rotorI.getAlfabet(3)
        assertEquals(expected, actual)
    }

    @Test
    fun when_callGetAlfabetWithLastIndexOfAlfabetListInputForFirstFromRotorWithPositionZero_Then_getFirstCharInList() {
        val posiyion = 0
        val rotorI = Rotor(list.toMutableList(), posiyion)
        val expected = "z"
        val actual = rotorI.getAlfabet(lastIndexOfAlfabetList)
        assertEquals(expected, actual)
    }

    @Test
    fun when_callGetAlfabetWithLastIndexOfAlfabetListInputForSecondTimeFromRotorWithPositionZero_Then_getSecondCharInList() {
        val posiyion = 0
        val rotorI = Rotor(list.toMutableList(), posiyion)
        var expected = "a"
        rotorI.getAlfabet(lastIndexOfAlfabetList)
        val actual = rotorI.getAlfabet(lastIndexOfAlfabetList)
        assertEquals(expected, actual)
    }

    @Test
    fun when_callGetAlfabetWithZiroInputForFirstTimeFromRotorWithPositionOne_Then_getFirstCharInList() {
        val posiyion = 1
        val rotorI = Rotor(list.toMutableList(), posiyion)
        val expected = "a"
        val actual = rotorI.getAlfabet(0)
        assertEquals(expected, actual)
    }

    @Test
    fun when_callGetAlfabetWithZiroInputForSecondTimeFromRotorWithPositionOne_Then_getFirstCharInList() {
        val posiyion = 1
        val rotorII = Rotor(list.toMutableList(), posiyion)
        val expected = "a"
        rotorII.getAlfabet(0)
        val actual = rotorII.getAlfabet(0)
        assertEquals(expected, actual)
    }

    @Test
    fun when_callGetAlfabetWithThreeInputForFirstTimeFromRotorWithPositionOne_Then_getFourthCharInList() {
        val posiyion = 1
        val rotorII = Rotor(list.toMutableList(), posiyion)
        val expected = "d"
        val actual = rotorII.getAlfabet(3)
        assertEquals(expected, actual)
    }

    @Test
    fun when_callGetAlfabetWithThreeInputForSecondTimeFromRotorWithPositionOne_Then_getFourthCharInList() {
        val posiyion = 1
        val rotorII = Rotor(list.toMutableList(), posiyion)
        var expected = "d"
        rotorII.getAlfabet(3)
        val actual = rotorII.getAlfabet(3)
        assertEquals(expected, actual)
    }

    @Test
    fun when_callGetAlfabetWithLastIndexOfAlfabetListInputForFirstFromRotorWithPositionOne_Then_getFirstCharInList() {
        val posiyion = 1
        val rotorII = Rotor(list.toMutableList(), posiyion)
        val expected = "z"
        val actual = rotorII.getAlfabet(lastIndexOfAlfabetList)
        assertEquals(expected, actual)
    }

    @Test
    fun when_callGetAlfabetWithLastIndexOfAlfabetListInputForSecondTimeFromRotorWithPositionOne_Then_getSecondCharInList() {
        val posiyion =1
        val rotorII = Rotor(list.toMutableList(), posiyion)
        var expected = "z"
        rotorII.getAlfabet(lastIndexOfAlfabetList)
        val actual = rotorII.getAlfabet(lastIndexOfAlfabetList)
        assertEquals(expected, actual)
    }

    @Test
    fun when_callGetAlfabetWithZiroInputAfterListSizeTimeCallFromRotorWithPositionOne_Then_getSecondCharInList() {
        val posiyion = 1
        val rotorI = Rotor(list.toMutableList(), posiyion)
        val expected = "b"
        for (i in 1..list.size) {
            rotorI.getAlfabet(0)
        }
        val actual = rotorI.getAlfabet(0)
        assertEquals(expected, actual)
    }

    @Test
    fun when_callGetAlfabetWithZiroInputAfterListSizePowPositionTimeCallFromRotorWithPositionOne_Then_getSecondCharInList() {
        val posiyion = 2
        val rotorI = Rotor(list.toMutableList(), posiyion)
        val expected = "b"
        for (i in 1.. Math.pow(list.size.toDouble(),posiyion.toDouble()).toInt()) {
            rotorI.getAlfabet(0)
        }
        val actual = rotorI.getAlfabet(0)
        assertEquals(expected, actual)
    }
}