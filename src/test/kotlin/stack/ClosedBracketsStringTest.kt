package stack

import org.example.stack.closedBrackets
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ClosedBracketsStringTest {
    @Test
    fun test_empty_string() {
        assertTrue(closedBrackets(""))
    }

    @Test
    fun test_lone_joker() {
        assertTrue( closedBrackets("J"))
    }

    @Test
    fun test_many_lone_jokers() {
        assertTrue(closedBrackets("JJJJJJJ"))
        assertTrue(closedBrackets("JJJJJJJJJ)"))
        assertTrue(closedBrackets("(JJJJJ"))
        assertTrue(closedBrackets("(JJJJJJJJJJ)"))
    }

    @Test
    fun test_trivial_balanced_string() {
        assertTrue( closedBrackets("()"))
    }

    @Test
    fun test_trivial_unbalanced_string() {
        assertFalse(closedBrackets("("))
        assertFalse(closedBrackets(")"))
        assertFalse(closedBrackets(")("))
    }

    @Test
    fun test_assorted_with_joker() {
        assertTrue(closedBrackets("(J))"))
        assertFalse(closedBrackets("()J("))
        assertTrue(closedBrackets("J)(J"))
        assertFalse(closedBrackets("(J()J(()(J"))
        assertFalse(closedBrackets("J(JJ()J((J"))
    }

    @Test
    fun test_code_wars_easy() {
        assertTrue(closedBrackets("((J)J)"))
        assertTrue(closedBrackets("(J)J((J)(J"))
        assertTrue(closedBrackets("J)JJ(JJ"))
    }
}