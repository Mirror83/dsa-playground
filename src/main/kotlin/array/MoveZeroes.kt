package org.example.array

/**
 * Moves all `0`'s to the end of `nums` while maintaining the relative order of the non-zero elements.
 * This is done in-place, and `nums` is modified.
 *
 * Approach
 * ---------
 * A two-pointer approach is used here, where i moves through the numbers in `nums`
 * from start to end. When a zero is encountered at index i, index j is increased until
 * a non-zero number that can be swapped with the encountered zero is found.
 *
 * Complexity
 * -----------
 * Runtime - O(n)
 * Space - O(1)
 * **/
fun moveZeroes(nums: Array<Int>) {
    var j = 1
    for (i in nums.indices) {
        if (j == nums.size) return

        if (nums[i] != 0) {
            j += 1
            continue
        }

        while (j < nums.size) {
            if (nums[j] == 0) {
                j += 1
                continue
            }
            // We've found a non-zero number
            // to swap with nums[i]
            nums[i] = nums[j]

            // The j++ is for moving j forward. There's no need to keep it here
            // for the next iteration since we know that the value at index j is zero
            nums[j++] = 0
            break
        }
    }
}