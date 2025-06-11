package org.example.linked_list

class ListNode (var `val`: Int, var next: ListNode?=null)

/** Returns a list containing all the elements in the linked list starting from the given ListNode **/
fun ListNode?.elements(): List<Int> {
    if (this == null) return emptyList()

    val elements = mutableListOf<Int>()

    var current = this
    while (current != null) {
        elements.add(current.`val`)
        current = current.next
    }

    return elements
}