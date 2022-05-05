package com.historicalenigmas.enigma.core.rotor

import java.util.Collections

class Rotor(private val alfabet: List<String>,private val position:Int) {
   private var callCount =0

    fun getAlfabet(charSignal: Int): String {
        callCount ++
        var char= alfabet[charSignal]
        if(Math.pow(alfabet.size.toDouble(),position.toDouble())<= callCount) {
            Collections.rotate(alfabet, -1)
            callCount=0;
        }
        return char;
    }
}