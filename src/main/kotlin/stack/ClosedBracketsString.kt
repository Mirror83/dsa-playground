package org.example.stack

import kotlin.collections.ArrayDeque

fun closedBrackets(s: String): Boolean {
    val stack = ArrayDeque<Char>()
    for (letter in s) {
        if (letter != ')') {
            // Also add J's, may be used to match with ')' later
            stack.addLast(letter)
        } else {
            if (stack.isEmpty()) return false
            // Also remove J's (found match with ')')
            stack.removeLast()
        }
    }

    if (stack.isNotEmpty()) {
        var current = stack.removeLast()
        // If were left with a single unbalanced parenthesis, return false
        if (current != 'J' && stack.isEmpty()) { return false }
        // If there are J's remaining in the stack, match them with the previous
        // '(' or J's, and continue on until there are no more J's on top of the stack
        // or the stack is empty
        while (current == 'J' && stack.isNotEmpty()) {
            current = stack.removeLast()
        }
    }

    return stack.isEmpty()
}