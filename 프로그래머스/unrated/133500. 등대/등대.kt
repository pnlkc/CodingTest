import java.util.*

class Solution {
    fun solution(n: Int, lighthouse: Array<IntArray>): Int {
        val map = mutableMapOf<Int, MutableList<Int>>()
        val queueVisit = BooleanArray(n + 1) { false }
        val stackVisit = BooleanArray(n + 1) { false }
        val light = BooleanArray(n + 1) { false }

        for (i in 1..n) {
            map[i] = mutableListOf()
        }
        for (h in lighthouse) {
            map[h[0]]!!.add(h[1])
            map[h[1]]!!.add(h[0])
        }

        val queue = LinkedList<Int>()
        queue.add(1)
        val stack = Stack<Int>()

        while (queue.isNotEmpty()) {
            val c = queue.poll()!!
            queueVisit[c] = true
            stack.add(c)

            for (i in map[c]!!) {
                if (!queueVisit[i]) {
                    queue.add(i)
                }
            }
        }

        while (stack.isNotEmpty()) {
            val c = stack.pop()!!
            stackVisit[c] = true

            for (i in map[c]!!) {
                if (!stackVisit[i]) {
                    if (!light[i] && !light[c]) light[i] = true
                }
            }
        }

        return light.count { it }
    }
}