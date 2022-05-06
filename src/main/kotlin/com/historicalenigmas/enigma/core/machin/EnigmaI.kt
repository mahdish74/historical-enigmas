package com.historicalenigmas.enigma.core.machin

import java.util.*

class EnigmaI {
    fun enCode(input: String): String {
        if(!input.matches("([A-Za-z-]+)".toRegex()))
            throw IllegalArgumentException()

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
        var callCount =0
        input.uppercase(Locale.getDefault()).toList().forEach {
            callCount ++
            Collections.rotate(rotorIList, -1)
            Collections.rotate(norRotorIList, -1)

            if ((callCount % 26)==0)
                Collections.rotate(rotorIIList,-1)
            if (((callCount % (26*26)) == 0 ))
                Collections.rotate(rotorIIIList,-1)

            val change1 = rotorIList[normalList.indexOf(it.toString())]
            val change2 = rotorIIList[norRotorIList.indexOf(change1)]
            val change3 = rotorIIIList[norRotorIIList.indexOf(change2)]
            val change4 = reflectorBList[norRotorIIIList.indexOf(change3)]
            val change5 = normalList[rotorIIIList.indexOf(norRotorIIIList[normalList.indexOf(change4)])]
            val change6 = normalList[rotorIIList.indexOf(norRotorIIList[normalList.indexOf(change5)])]
            val change7 = normalList[rotorIList.indexOf(norRotorIList[normalList.indexOf(change6)])]
            outPut += change7

        }
        return outPut
    }
}