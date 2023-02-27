import java.util.LinkedList
class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        val map = want.mapIndexed { i, s -> s to number[i] }
        val queueDiscount = LinkedList<String>()
        queueDiscount.addAll(discount)
        queueDiscount.add("")
        val queue = LinkedList<String>()

        while (queueDiscount.isNotEmpty()) {
            if (queue.size < 10) {
                queue.add(queueDiscount.poll()!!)
            } else {
                var result = true
                for (m in map) {
                    if (queue.count { it == m.first } != m.second) {
                        result = false
                        break
                    }
                }
                if (result) answer++
                queue.poll()
            }
        }

        return answer
    }
}