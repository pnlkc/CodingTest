import java.util.*

class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer = 0
        val queue = LinkedList<Int>()
        queue.addAll(section.toList())

        while (queue.isNotEmpty()) {
            val num = queue.poll()!!
            answer++

            while (queue.isNotEmpty()) {
                val next = queue.peek()!!
                if (next > num + m - 1) break else queue.poll()
            }
        }
        return answer
    }
}