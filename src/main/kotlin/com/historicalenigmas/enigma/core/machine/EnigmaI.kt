package com.historicalenigmas.enigma.core.machine

import java.util.*

class EnigmaI {
    companion object {
        private const val ROTOR_I_NOTCH = 'Q'
        private const val ROTOR_II_NOTCH = 'E'
    }

    fun enCode(input: String): String {
        if (!input.matches("([A-Za-z-]+)".toRegex()))
            throw IllegalArgumentException()

        val plugboard = Plugboard()

        val normalList: MutableList<String> = arrayListOf()
        val rotorIList: MutableList<String> = arrayListOf()
        val rotorIIList: MutableList<String> = arrayListOf()
        val rotorIIIList: MutableList<String> = arrayListOf()
        val reflectorBList: MutableList<String> = arrayListOf()

        "EKMFLGDQVZNTOWYHXUSPAIBRCJ".forEach { rotorIList.add(it.toString()) }
        "AJDKSIRUXBLHWTMCQGZNPYFVOE".forEach { rotorIIList.add(it.toString()) }
        "BDFHJLCPRTXVZNYEIWGAKMUSQO".forEach { rotorIIIList.add(it.toString()) }
        "YRUHQSLDPXNGOKMIEBFZCWVJAT".forEach { reflectorBList.add(it.toString()) }
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ".forEach { normalList.add(it.toString()) }

        val norRotorIList: MutableList<String> = normalList.toMutableList()
        val norRotorIIList: MutableList<String> = normalList.toMutableList()
        val norRotorIIIList: MutableList<String> = normalList.toMutableList()

        var outPut = ""
        var callCount = 0

        input.uppercase(Locale.getDefault()).forEach { char ->
            callCount++
            Collections.rotate(rotorIList, -1)
            Collections.rotate(norRotorIList, -1)

            if (rotorIList.get(0).equals(ROTOR_I_NOTCH)) {
                Collections.rotate(rotorIIList, -1)
                Collections.rotate(norRotorIIList, -1)

            }
            if (rotorIIList.get(0).equals(ROTOR_II_NOTCH)) {
                Collections.rotate(rotorIIIList, -1)
                Collections.rotate(norRotorIIIList, -1)
            }

            if (char == '-') {
                outPut += '-'
                return@forEach
            }

            val swappedBefore = plugboard.swap(char.toString())

            val change1 = rotorIList[normalList.indexOf(swappedBefore)]
            val change2 = rotorIIList[norRotorIList.indexOf(change1)]
            val change3 = rotorIIIList[norRotorIIList.indexOf(change2)]

            val change4 = reflectorBList[norRotorIIIList.indexOf(change3)]

            val change5 = normalList[rotorIIIList.indexOf(norRotorIIIList[normalList.indexOf(change4)])]
            val change6 = normalList[rotorIIList.indexOf(norRotorIIList[normalList.indexOf(change5)])]
            val change7 = normalList[rotorIList.indexOf(norRotorIList[normalList.indexOf(change6)])]

            val swappedAfter = plugboard.swap(change7)

            outPut += swappedAfter
        }

        return outPut
    }
}
