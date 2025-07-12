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
fun recursiveClosedBracketsWithoutJoker(s: String): Boolean {
    // The empty string is trivially balanced
    if (s.isEmpty()) return true

    val openBracketCount = openBracketCountWithoutJoker(s.reversed())
    return openBracketCount == 0
}

private fun openBracketCountWithoutJoker(s: String): Int {
    println(s)
    if (s.length > 1) {
        val count = openBracketCountWithoutJoker(s.slice(1..<s.length))
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

fun recursiveClosedBrackets(s: String): Boolean {
    if (s.isEmpty()) return true

//    return evaluateAllCombinations(s)
    return memoizedEvaluateAllCombinations(s)
}

/** Recursively checks if all combinations of strings (`s` with wildcard replacement)
 * evaluate to a balanced string.
 *
 * Returns `true` if `s` is balanced and `false` otherwise
 *
 * Parameters
 * -----------
 * s - The string to be evaluated
 * index - The index of the current character in `s` under consideration
 * openBracketCount - The number of open brackets at `index`
 * **/
private fun evaluateAllCombinations(
    s: String,
    index: Int = 0,
    openBracketCount: Int = 0
): Boolean {
    if (openBracketCount < 0) {
        // It means we have encountered a closing bracket without a corresponding
        // closing bracket
        return false
    }
    if (index >= s.length) {
        return openBracketCount == 0
    }
    val currentChar = s[index]

    return when (currentChar) {
        '(' -> {
            evaluateAllCombinations(s, index + 1, openBracketCount + 1)
        }

        ')' -> {
            evaluateAllCombinations(s, index + 1, openBracketCount - 1)
        }
        // Here, we assume that the string does not contain invalid characters
        else -> {
            // When encountering a Joker, we consider what would happen when replacing it
            // will all the possible symbols
            evaluateAllCombinations(s, index + 1, openBracketCount + 1)
                    || evaluateAllCombinations(s, index + 1, openBracketCount - 1)
                    || evaluateAllCombinations(s, index + 1, openBracketCount)
        }
    }
}

/** Recursively checks if all combinations of strings (`s` with wildcard replacement)
 * evaluate to a balanced string.
 *
 * Returns `true` if `s` is balanced and `false` otherwise
 *
 * Parameters
 * -----------
 * s - The string to be evaluated
 * index - The index of the current character in `s` under consideration
 * openBracketCount - The number of open brackets at `index`
 * memo - A map holding the results of evaluating the string at `index`
 *
 * **/
private fun memoizedEvaluateAllCombinations(
    s: String, index: Int = 0,
    openBracketCount: Int = 0,
    memo: MutableMap<Pair<Int, Int>, Boolean> = mutableMapOf()
): Boolean {
    val pair = Pair(index, openBracketCount)
    if (pair in memo) return memo[pair]!!

    if (openBracketCount < 0) {
        // It means we have encountered a closing bracket without a corresponding
        // closing bracket
        memo[pair] = false
        return memo[pair]!!
    }
    if (index >= s.length) {
        memo[pair] = openBracketCount == 0
        return memo[pair]!!
    }
    val currentChar = s[index]

    val result = when (currentChar) {
        '(' -> {
            memoizedEvaluateAllCombinations(s, index + 1, openBracketCount + 1, memo)
        }

        ')' -> {
            memoizedEvaluateAllCombinations(s, index + 1, openBracketCount - 1, memo)
        }
        // Here, we assume that the string does not contain invalid characters
        else -> {
            // When encountering a Joker, we consider what would happen when replacing it
            // will all the possible symbols
            memoizedEvaluateAllCombinations(s, index + 1, openBracketCount + 1, memo)
                    || memoizedEvaluateAllCombinations(s, index + 1, openBracketCount - 1, memo)
                    || memoizedEvaluateAllCombinations(s, index + 1, openBracketCount, memo)
        }
    }
    memo[pair] = result
    return memo[pair]!!
}

fun main() {
    println(recursiveClosedBracketsWithoutJoker(")("))  // false
    println(closedBrackets("JJJ()J)J"))  // true
    println(recursiveClosedBrackets("JJJ()J)JJ)))))))")) // false
}