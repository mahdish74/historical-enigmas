package com.historicalenigmas.enigma.controller

import com.historicalenigmas.enigma.service.EnigmaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EnigmaIController(@Autowired val enigmaIService: EnigmaService) {

    @GetMapping("/enigmaI/encode/{input}")
    fun encode( @PathVariable input: String): String {
        return enigmaIService.encode(input)
    }

}