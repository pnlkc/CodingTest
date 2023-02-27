class Solution {
    var answer = 0
    fun solution(info: IntArray, edges: Array<IntArray>): Int {
        calc(info, edges)
        return answer
    }

    fun calc(
        info: IntArray,
        edges: Array<IntArray>,
        count: IntArray = intArrayOf(1, 0),
        used: MutableList<Int> = mutableListOf(0),
    ) {
        if (count[0] <= count[1] || count[0] == info.count { it == 0 }) {
            if (answer < count[0]) answer = count[0]
        } else {
            for (i in edges.indices) {
                if (used.contains(edges[i][0]) && !used.contains(edges[i][1])) {
                    val tempCount = count.clone()
                    val tempUsed = used.toMutableList()
                    if (info[edges[i][1]] == 0) tempCount[0]++ else tempCount[1]++
                    tempUsed.add(edges[i][1])
                    calc(info, edges, tempCount, tempUsed)
                }
            }
        }
    }
}