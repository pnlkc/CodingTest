import java.util.LinkedList
class Solution {
    fun solution(n: Int, roads: Array<IntArray>, sources: IntArray, d: Int): IntArray {
        val map = mutableMapOf<Int, MutableList<Int>>()
        val answer = IntArray(sources.size) { -1 }
        val result = IntArray(n + 1) { -1 }
        for (it in roads) {
            if (map[it[0]] == null) map[it[0]] = mutableListOf(it[1]) else map[it[0]]!!.add(it[1])
            if (map[it[1]] == null) map[it[1]] = mutableListOf(it[0]) else map[it[1]]!!.add(it[0])
        }
        result[d] = 0

        val visit = BooleanArray(n + 1) { false }
        val queue = LinkedList<Int>()
        queue.add(d)
        visit[d] = true
        var depth = 1
        var lastNum = d

        while (queue.isNotEmpty()) {
            val c = queue.poll()!!
            if (map[c] == null) continue
            for (i in map[c]!!) {
                if (!visit[i]) {
                    visit[i] = true
                    queue.add(i)
                    result[i] = depth
                }
            }
            if (c == lastNum) {
                depth++
                if (queue.isNotEmpty()) lastNum = queue.last()
            }
        }

        for (i in sources.indices) { answer[i] = result[sources[i]] }

        return answer
    }
}
