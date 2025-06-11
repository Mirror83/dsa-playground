import org.example.linked_list.ListNode
import org.example.linked_list.findLinkedListMidpoint
import org.example.linked_list.isPalindrome
import org.example.linked_list.isPalindromeWithLessSpace
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

val correctPalindromeLists = mutableListOf(
    ListNode(1, ListNode(1)),
    ListNode(1, ListNode(1, ListNode(1))),
    ListNode(1, ListNode(2, ListNode(1))),
    ListNode(1, ListNode(2, ListNode(2, ListNode(1))))
)

val evenNumberLengthPalindromeLists = mutableListOf(
    ListNode(1, ListNode(1)),
    ListNode(1, ListNode(2, ListNode(2, ListNode(1))))
)

val oddNumberLengthPalindromeLists = mutableListOf(
//    ListNode(1,),  // OK
    ListNode(1, ListNode(2, ListNode(1))), // Not OK
    ListNode(4, ListNode(1, ListNode(3, ListNode(1, ListNode(4)))))  // Not OK
    )

val incorrectPalindromeLists = mutableListOf(
    ListNode(1, ListNode(2)),
    ListNode(2, ListNode(3, ListNode(5))),
    ListNode(2, ListNode(2, ListNode(1))),
    ListNode(1, ListNode(7, ListNode(2, ListNode(1))))
)

class PalindromeCheckerTest {
    @Test
    fun isPalindrome_withEmptyLinkedList() {
        assertTrue(isPalindrome(null))
    }

    @Test
    fun isPalindrome_withSingleElementList() {
        assertTrue(isPalindrome(ListNode(10)))
    }

    @Test
    fun isPalindrome_correctPalindromeLinkedLists() {
        for (list in correctPalindromeLists) {
            assertTrue(isPalindrome(list))
        }
    }

    @Test
    fun isPalindrome_incorrectPalindromeLinkedLists() {
        for (list in incorrectPalindromeLists) {
            assertFalse(isPalindrome(list))
        }
    }
}

class PalindromeWithLessSpaceTest {
    @Test
    fun findLinkedListMidpoint_shouldFindCorrectMidpoint() {
        val list = ListNode(1, ListNode(2, ListNode(1)))
        assertEquals(findLinkedListMidpoint(list)?.`val`, 2)
    }
    @Test
    fun isPalindromeWithLessSpace_withEmptyLinkedList() {
        assertTrue(isPalindromeWithLessSpace(null))
    }

    @Test
    fun isPalindromeWithLessSpace_withSingleElementList() {
        assertTrue(isPalindromeWithLessSpace(ListNode(10)))
    }

    @Test
    fun isPalindromeWithLessSpace_correctPalindromeLinkedListsWithEvenLength() {
        for (list in evenNumberLengthPalindromeLists) {
            assertTrue(isPalindromeWithLessSpace(list))
        }
    }

    @Test
    fun isPalindromeWithLessSpace_correctPalindromeLinkedListsWithOddLength() {
        for (list in oddNumberLengthPalindromeLists) {
            assertTrue(isPalindromeWithLessSpace(list))
        }
    }

    @Test
    fun isPalindromeWithLessSpace_incorrectPalindromeLinkedLists() {
        for (list in incorrectPalindromeLists) {
            assertFalse(isPalindromeWithLessSpace(list))
        }
    }
}