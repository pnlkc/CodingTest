class Solution {
    var result = true
    fun solution(n: Int, costs: Array<IntArray>): Int {
        val usedList = mutableListOf<IntArray>()
        val sortCosts = costs.sortedBy { it[2] }
        for (cost in sortCosts) {
            result = true
            calc(0, usedList, cost[1], mutableListOf(cost[0]))
            if (result) {
                usedList.add(cost)
                if (usedList.size == n - 1) break
            }
        }
        return usedList.sumOf { it[2] }
    }

    fun calc(
        startIndex: Int,
        usedList: MutableList<IntArray>,
        target: Int,
        numList: MutableList<Int>,
    ) {
        val temp = numList.toMutableList()
        val condition = numList.slice(startIndex..numList.lastIndex)
        for (i in usedList) {
            val slice = i.slice(0..1)
            if ((slice - condition).size == 1) {
                val leftNum = (slice - condition)[0]
                if (leftNum == target) {
                    result = false
                    break
                } else {
                    if (!temp.contains(leftNum)) temp.add(leftNum)
                }
            }
        }
        if (result && temp.size != numList.size) {
            calc(numList.lastIndex + 1, usedList, target, temp)
        }
    }
}