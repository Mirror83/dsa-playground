package org.example.stack


fun recursiveClosedBrackets(s: String): Boolean {
    // The empty string is trivially balanced
    if (s.isEmpty()) return true

    val openBracketCount = openBracketCount(s.reversed())
    return openBracketCount == 0
}

private fun openBracketCount(s: String): Int {
    println(s)
    if (s.length > 1) {
        val count = openBracketCount(s.slice(1..<s.length))
        // We have too many right brackets to ever balance with the left brackets
        if (count < 0) return -1
        return evaluateBracket(s[0]) + count
    } else {
        return evaluateBracket(s[0])
    }
}

private fun evaluateBracket(c: Char): Int {
    return if (c == '(') {
        1
    } else {
        -1
    }
}

fun main() {
    println(recursiveClosedBrackets(")("))
}