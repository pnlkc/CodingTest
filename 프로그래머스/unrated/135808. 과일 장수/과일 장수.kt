import java.util.LinkedList
class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer: Int = 0
        val queue = LinkedList<Int>()
        queue.addAll(score.sortedDescending())
        while (queue.size >= m) {
            repeat(m - 1) {queue.poll()}
            val num = queue.poll()!!
            answer += num * m
        }
        return answer
    }
}
