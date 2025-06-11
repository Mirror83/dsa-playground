import org.example.linked_list.ListNode
import org.example.linked_list.elements
import org.example.linked_list.findLinkedListMidpoint
import org.example.linked_list.isPalindrome
import org.example.linked_list.isPalindromeWithLessSpace
import org.example.linked_list.reverseLinkedList
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class PalindromeLinkedListTestData {
    val correctPalindromeLists = listOf(
        ListNode(1, ListNode(1)),
        ListNode(1, ListNode(1, ListNode(1))),
        ListNode(1, ListNode(2, ListNode(1))),
        ListNode(1, ListNode(2, ListNode(2, ListNode(1))))
    )

    val evenNumberLengthPalindromeLists = listOf(
        ListNode(1, ListNode(1)),
        ListNode(1, ListNode(2, ListNode(2, ListNode(1))))
    )

    val oddNumberLengthPalindromeLists = listOf(
        ListNode(1),
        ListNode(1, ListNode(2, ListNode(1))),
        ListNode(4, ListNode(1, ListNode(3, ListNode(1, ListNode(4)))))
    )

    val incorrectPalindromeLists = listOf(
        ListNode(1, ListNode(2)),
        ListNode(2, ListNode(3, ListNode(5))),
        ListNode(2, ListNode(2, ListNode(1))),
        ListNode(1, ListNode(7, ListNode(2, ListNode(1))))
    )
}

class PalindromeCheckerTest {
    lateinit var testData: PalindromeLinkedListTestData

    @BeforeTest
    fun setUp() {
        testData = PalindromeLinkedListTestData()
    }

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
        for (list in testData.correctPalindromeLists) {
            assertTrue(isPalindrome(list))
        }
    }

    @Test
    fun isPalindrome_incorrectPalindromeLinkedLists() {
        for (list in testData.incorrectPalindromeLists) {
            assertFalse(isPalindrome(list))
        }
    }
}

class PalindromeWithLessSpaceTest {
    lateinit var testData: PalindromeLinkedListTestData

    @BeforeTest
    fun setUp() {
        testData = PalindromeLinkedListTestData()
    }

    @Test
    fun findLinkedListMidpoint_shouldFindCorrectMidpoint() {
        val list = ListNode(1, ListNode(2, ListNode(1)))
        assertEquals(findLinkedListMidpoint(list)?.`val`, 2)
    }

    @Test
    fun reverseLinkedList_withEmptyLinkedList() {
        assertNull(reverseLinkedList(null))
    }

    @Test
    fun reverseLinkedList_withSingleElementList() {
        assertEquals(
            ListNode(10).elements(),
            reverseLinkedList(ListNode(10)).elements())
    }

    @Test
    fun reverseLinkedList_withManyElementList() {
        for (list in testData.incorrectPalindromeLists) {
            assertEquals(list.elements().reversed(), reverseLinkedList(list).elements())
        }

        for (list in testData.correctPalindromeLists) {
            assertEquals(list.elements(), reverseLinkedList(list).elements())
        }
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
        for (list in testData.evenNumberLengthPalindromeLists) {
            assertTrue(isPalindromeWithLessSpace(list))
        }
    }

    @Test
    fun isPalindromeWithLessSpace_correctPalindromeLinkedListsWithOddLength() {
        for (list in testData.oddNumberLengthPalindromeLists) {
            assertTrue(isPalindromeWithLessSpace(list))
        }
    }

    @Test
    fun isPalindromeWithLessSpace_incorrectPalindromeLinkedLists() {
        for (list in testData.incorrectPalindromeLists) {
            assertFalse(isPalindromeWithLessSpace(list))
        }
    }
}