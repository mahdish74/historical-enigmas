package com.historicalenigmas.enigma.service

import com.historicalenigmas.enigma.core.machin.EnigmaI
import org.springframework.stereotype.Service

@Service
class EnigmaService {
    fun encode(input:String):String{
        val enigmaI=EnigmaI();
        return enigmaI.enCode(input)
    }

}