import java.util.LinkedList
class Solution {
    fun solution(maps: Array<String>): Int {
        val pos = arrayOf(intArrayOf(-1, -1), intArrayOf(-1, -1), intArrayOf(-1, -1))

        for (i in maps.indices) {
            for (j in maps[0].indices) {
                when (maps[i][j]) {
                    'S' -> pos[0] = intArrayOf(i, j)
                    'L' -> pos[1] = intArrayOf(i, j)
                    'E' -> pos[2] = intArrayOf(i, j)
                }
                if (pos.count { it.contains(-1) } == 0) break
            }
        }

        val result = intArrayOf(calc(maps, pos[0], pos[1]), calc(maps, pos[1], pos[2]))
        return if (result.contains(-1)) -1 else result.sum()
    }

    fun calc(maps: Array<String>, pos: IntArray, goal: IntArray): Int {
        val queue = LinkedList<IntArray>()
        val graph = Array(maps.size) { IntArray(maps[0].length) { -1 } }
        graph[pos[0]][pos[1]] = 0
        queue.add(pos)

        while (queue.isNotEmpty()) {
            val c = queue.pop()!!
            val diff = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)

            for (i in diff.indices) {
                val nY = c[0] + diff[i].first
                val nX = c[1] + diff[i].second

                if (nY in graph.indices && nX in graph[0].indices && maps[nY][nX] != 'X') {
                    if (graph[nY][nX] == -1 || graph[nY][nX] > graph[c[0]][c[1]] + 1) {
                        graph[nY][nX] = graph[c[0]][c[1]] + 1
                        queue.add(intArrayOf(nY, nX))
                    }
                }
            }
        }

        return if (graph[goal[0]][goal[1]] == -1) -1 else graph[goal[0]][goal[1]]
    }
}