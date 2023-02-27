import java.util.*
class Solution {
    fun solution(a: IntArray, edges: Array<IntArray>): Long {
        var answer = 0L
        val aLong = a.map { it.toLong() }.toLongArray()
        if (aLong.sum() != 0L) return -1L
        val queueB = BooleanArray(a.size) { true }
        val stackB = BooleanArray(a.size) { true }
        val map = mutableMapOf<Int, MutableList<Int>>()
        edges.forEach {
            if (map[it[0]] == null) map[it[0]] = mutableListOf(it[1]) else map[it[0]]!!.add(it[1])
            if (map[it[1]] == null) map[it[1]] = mutableListOf(it[0]) else map[it[1]]!!.add(it[0])
        }

        val stack = Stack<Int>()
        val queue = LinkedList<Int>()
        queue.add(0)
        stack.add(0)

        while (queue.isNotEmpty()) {
            val n = queue.poll()!!
            queueB[n] = false
            map[n]!!.forEach {
                if (queueB[it]) {
                    queue.add(it)
                    stack.add(it)
                }
            }
        }

        while (stack.isNotEmpty()) {
            val n = stack.pop()!!
            stackB[n] = false
            map[n]!!.forEach {
                if (stackB[it]) {
                    aLong[it] += aLong[n]
                    answer += if (aLong[n] < 0L) aLong[n] * -1L else aLong[n]
                    aLong[n] = 0
                }
            }
        }

        return answer
    }
}