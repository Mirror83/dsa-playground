package stack

import org.example.stack.recursiveClosedBrackets
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ClosedBracketsStringTest {
    @Test
    fun test_empty_string() {
        assertTrue(recursiveClosedBrackets(""))
    }

    @Test
    fun test_lone_joker() {
        assertTrue( recursiveClosedBrackets("J"))
    }

    @Test
    fun test_many_lone_jokers() {
        assertTrue(recursiveClosedBrackets("JJJJJJJ"))
        assertTrue(recursiveClosedBrackets("JJJJJJJJJ)"))
        assertTrue(recursiveClosedBrackets("(JJJJJ"))
        assertTrue(recursiveClosedBrackets("(JJJJJJJJJJ)"))
    }

    @Test
    fun test_trivial_balanced_string() {
        assertTrue( recursiveClosedBrackets("()"))
    }

    @Test
    fun test_trivial_unbalanced_string() {
        assertFalse(recursiveClosedBrackets("("))
        assertFalse(recursiveClosedBrackets(")"))
        assertFalse(recursiveClosedBrackets(")("))
    }

    @Test
    fun test_assorted_without_joker() {
        assertTrue(recursiveClosedBrackets("(())"))
        assertTrue(recursiveClosedBrackets("()()"))
        assertFalse(recursiveClosedBrackets(")()"))
        assertFalse(recursiveClosedBrackets("(()(()("))
        assertFalse(recursiveClosedBrackets("(()(("))
    }

    @Test
    fun test_assorted_with_joker() {
        assertTrue(recursiveClosedBrackets("(J))"))
        assertFalse(recursiveClosedBrackets("()J("))
        assertTrue(recursiveClosedBrackets("J)(J"))
        assertFalse(recursiveClosedBrackets("(J()J(()(J"))
        assertFalse(recursiveClosedBrackets("J(JJ()J((J"))
    }

    @Test
    fun test_code_wars_easy() {
        assertTrue(recursiveClosedBrackets("((J)J)"))
        assertTrue(recursiveClosedBrackets("(J)J((J)(J"))
        assertTrue(recursiveClosedBrackets("J)JJ(JJ"))
    }
}