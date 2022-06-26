package rabinkarp

import kotlin.math.pow

fun getCode(char: Char): Int {
    return if (char.isUpperCase()) {
        char.code
    } else {
        char.code
    }
}

fun calculateHash(subString: String, a: Int, m: Int): Int {
    var hash = 0
    for (index in subString.indices) {
        val calculatedHash = (getCode(subString[index]) * a.toDouble().pow(index)).toInt()
        hash += calculatedHash
    }

    return hash % m
}

fun calculateRollingHash(subString: String, a: Int, m: Int, lastChar: Char?, lastHash: Int): Int {
    return if (lastChar == null) {
        calculateHash(subString, a, m)
    } else {
        val removeHash = (getCode(lastChar) * a.toDouble().pow(subString.lastIndex)).toInt()
        val nethash = ((lastHash - removeHash) * a + getCode(subString.first()))
        var rem = nethash.rem(m)
        if (rem < 0) {
            rem += m
        } else {
            rem
        }

        return rem
    }
}

fun main() {
    val pattern = "-----BEGIN\\ CERTIFICATE-----"
    val text = "-----BEGIN\\ CERTIFICATE-----pmview"
    var startIndex = text.length - pattern.length
    var endIndex = text.length
    var lastChar: Char? = null
    var lastHash = 0
    val patterHash = calculateHash(pattern, 3, 11)

    println(calculateHash("EGIN\\ CERTIFICATE-----pmview", 3, 11))
    println(calculateHash("BEGIN\\ CERTIFICATE-----pmvie", 3, 11))
    println(calculateHash("-BEGIN\\ CERTIFICATE-----pmvi", 3, 11))
    println(calculateHash("--BEGIN\\ CERTIFICATE-----pmv", 3, 11))
    println(calculateHash("---BEGIN\\ CERTIFICATE-----pm", 3, 11))
    println(calculateHash("----BEGIN\\ CERTIFICATE-----p", 3, 11))
    println(calculateHash("-----BEGIN\\ CERTIFICATE-----", 3, 11))
    while(startIndex >= 0) {
        val subString = text.substring(startIndex, endIndex)
        val subStrHash = calculateRollingHash(subString = subString, 3, 11, lastChar, lastHash)
        println("$subString $subStrHash $pattern $patterHash")
        if (patterHash == subStrHash && pattern == subString) {
            println("Pattern found at: $startIndex")
        }
        lastChar = subString.last()
        lastHash = subStrHash
        --startIndex
        --endIndex
    }
}