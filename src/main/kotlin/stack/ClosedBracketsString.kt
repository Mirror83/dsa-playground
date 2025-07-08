package org.example.stack

import kotlin.math.max

/**
 * Returns `true` if a string containing parenthesis (including a Joker character 'J')
 * is balanced, and `false` otherwise.
 *
 * The Joker can be transformed into a '(', ')' or ignored altogether.
 *
 * Complexity
 * -----------
 * Runtime complexity: 0(n)
 * Space complexity: 0(n)
 *
 * Approach
 * -----------
 * The algorithm follows a greedy approach, turning converting a Joker into either '(' or ')' whenever
 * it is encountered. This is encoded by two variables:
 * - `maxOpen`: The maximum number of open parenthesis (resulting from converting every Joker into '(')
 * - `minOpen`: The minimum number of open parenthesis (resulting from converting every Joker into ')')
 *
 * For the string to be balanced, `minOpen` should be 0 (i.e. each '(' is closed)
 * */
fun closedBrackets(s: String): Boolean {
    var maxOpen = 0
    var minOpen = 0

    for (c in s) {
        when (c) {
            '(' -> {
                maxOpen += 1
                minOpen += 1
            }
            ')' -> {
                maxOpen -= 1
                if (maxOpen < 0) return false  // Encountered too many ")"
                minOpen = max(0, minOpen - 1)
            }
            'J' -> {
                minOpen = max(0, minOpen - 1)
                maxOpen += 1
            }
        }
    }
    return minOpen == 0
}


/** Checks whether a string of just parenthesis is balanced
 * */
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