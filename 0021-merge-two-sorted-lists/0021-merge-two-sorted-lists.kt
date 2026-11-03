class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var l1 = list1
        var l2 = list2
        var result: ListNode? = null
        var pointer: ListNode? = null

        while (l1 != null || l2 != null) {
            var next: ListNode? = null 
            
            if (l1 != null && l2 != null) {
                if (l1.`val` <= l2.`val`) {
                    next = ListNode(l1.`val`)
                    l1 = l1.next
                } else {
                    next = ListNode(l2.`val`)
                    l2 = l2.next
                }
            } else if (l1 != null) {
                next = ListNode(l1.`val`)
                l1 = l1.next
            } else {
                next = ListNode(l2!!.`val`)
                l2 = l2.next
            }
            
            if (result == null) {
                result = next
                pointer = next
            } else {
                pointer!!.next = next
                pointer = pointer.next
            }
        }

        return result
    }
}