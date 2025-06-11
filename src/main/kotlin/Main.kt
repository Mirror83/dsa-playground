package org.example

import org.example.linked_list.ListNode
import org.example.linked_list.elements
import org.example.linked_list.isPalindromeWithLessSpace

fun main() {
    val list = ListNode(3, next = ListNode(7, next = ListNode(2, next = ListNode(1))))
    println(list.elements())
//    val list2 = ListNode(1, next = ListNode(2))
    println(isPalindromeWithLessSpace(list))
//    println(isPalindrome(list2))
}