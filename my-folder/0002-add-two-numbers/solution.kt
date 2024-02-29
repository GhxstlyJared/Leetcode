
class Solution {
   fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var carry = 0
        var head: ListNode? = null
        var tail: ListNode? = null

        var l1Current = l1
        var l2Current = l2

        while (l1Current != null || l2Current != null || carry != 0) {
            val sum = (l1Current?.`val` ?: 0) + (l2Current?.`val` ?: 0) + carry
            carry = sum / 10
            val node = ListNode(sum % 10)

            if (head == null) {
                head = node
                tail = node
            } else {
                tail?.next = node
                tail = node
            }

            l1Current = l1Current?.next
            l2Current = l2Current?.next
        }

        return head
    }
}
