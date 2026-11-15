class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val result = head
        var current: ListNode? = head
        var next: ListNode? = current?.next

        while (current?.next != null) {
            if (next?.`val` == current.`val`) {
                next = next.next
            } else {
                current.next = next
                current = current.next
                next = next?.next
            }
        }

        return result
    }
}