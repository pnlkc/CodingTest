import java.util.PriorityQueue
class Solution {
    fun solution(n: Int, paths: Array<IntArray>, gates: IntArray, summits: IntArray): IntArray {
        var answer: IntArray = intArrayOf(50_001, 10_000_001)
        val isGates = BooleanArray(n + 1) { false }
        for (gate in gates) {
            isGates[gate] = true
        }

        val isSummits = BooleanArray(n + 1) { false }
        for (summit in summits) {
            isSummits[summit] = true
        }

        val map = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
        for (i in 1..n) {
            map[i] = mutableListOf()
        }
        val time = mutableMapOf<String, Int>()

        for (path in paths) {
            map[path[0]]!!.add(Pair(path[1], path[2]))
            map[path[1]]!!.add(Pair(path[0], path[2]))
            time["${path[0]} ${path[1]}"] = path[2]
            time["${path[1]} ${path[0]}"] = path[2]
        }

        for (s in summits) {
            var min = 10_000_001
            val list = IntArray(n + 1) { 10_000_001 }

            val queue = PriorityQueue<Pair<Int, Int>> { p1, p2 -> p1.second - p2.second }

            queue.add(Pair(s, 0))

            while (queue.isNotEmpty()) {
                val (cN, cI) = queue.poll()!!
                if (cI > answer[1]) break
                if (cN != s && (isGates[cN] || isSummits[cN])) continue
                if (list[cN] < cI) continue
                for (m in map[cN]!!) {
                    val intensity = maxOf(cI, m.second)
                    if (intensity < list[m.first]) {
                        list[m.first] = intensity
                        if (isGates[m.first] && min > intensity) min = intensity
                        queue.add(Pair(m.first, intensity))
                    }
                }
            }

            when {
                min < answer[1] -> answer = intArrayOf(s, min)
                min == answer[1] -> if (answer[0] > s) answer[0] = s
            }
        }

        return answer
    }
}