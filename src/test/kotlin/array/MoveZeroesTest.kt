package array

import org.example.array.moveZeroes
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertTrue

class MoveZeroesTest {
    @Test
    fun test_single_zero() {
        val nums = arrayOf(0)
        moveZeroes(nums)
        assertTrue(nums contentEquals nums)
    }

    @Test
    fun test_simple_without_zeroes() {
        val numArrays = arrayOf(
            arrayOf(1,2,3),
            arrayOf(2),
            arrayOf(189, 82,1,3)
        )

        for (nums in numArrays) {
            val clone = nums.clone()
            moveZeroes(clone)
            assertContentEquals(nums, clone)
        }
    }

    @Test
    fun test_simple_with_zeroes() {
        val numArrays = arrayOf(
            arrayOf(0,1,0,3,12),
            arrayOf(0,0,0,0,1),
            arrayOf(2,4,3,9,0,1)
        )

        val solutions = arrayOf(
            arrayOf(1,3,12,0,0),
            arrayOf(1,0,0,0,0),
            arrayOf(2,4,3,9,1,0),
        )

        for (i in numArrays.indices) {
            moveZeroes(numArrays[i])
            assertContentEquals(solutions[i], numArrays[i])
        }
    }
}