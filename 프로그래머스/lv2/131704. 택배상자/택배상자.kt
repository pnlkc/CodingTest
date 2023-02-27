import java.util.*
class Solution {
    fun solution(order: IntArray): Int {
        var answer: Int = 0
        val queue = LinkedList<Int>()
        queue.addAll(order.toTypedArray())
        var c = queue.poll()!!
        val stack = Stack<Int>()
        for (i in 1..order.size) {
            if (c == i) {
                answer++
                if (queue.isNotEmpty()) c = queue.poll()!!
            } else {
                while (stack.isNotEmpty() && stack.peek() == c) {
                    answer++
                    stack.pop()
                    if (queue.isNotEmpty()) c = queue.poll()!!
                }
                stack.add(i)
            }
        }
        while (stack.isNotEmpty() && stack.peek() == c) {
            answer++
            stack.pop()
            if (queue.isNotEmpty()) c = queue.poll()!!
        }
        return answer
    }
}