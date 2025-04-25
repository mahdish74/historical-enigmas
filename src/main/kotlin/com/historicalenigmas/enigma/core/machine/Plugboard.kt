package com.historicalenigmas.enigma.core.machine

class Plugboard(
    private val wiring: Map<String, String> = mapOf(
        "A" to "G",
        "G" to "A",
        "H" to "Q",
        "Q" to "H",
        "L" to "P",
        "P" to "L"
    )
) {
    fun swap(c: String): String {
        return wiring[c] ?: c
    }
}