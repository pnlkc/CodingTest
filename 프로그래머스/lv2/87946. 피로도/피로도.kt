class Solution {
    var answer = 0
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        val sortedList = dungeons.sortedBy { it.first() }
        calc(k, sortedList)
        return answer
    }

    fun calc(k: Int, sortedList: List<IntArray>, usedList: MutableList<Int> = mutableListOf()) {
        if (sortedList.first()[0] > k || usedList.size == sortedList.size) {
            if (usedList.size >= answer) answer = usedList.size
        } else {
            for (i in sortedList.indices) {
                if (sortedList[i][0] <= k && !usedList.contains(i)) {
                    usedList.add(i)
                    calc(k - sortedList[i][1], sortedList, usedList)
                    usedList.removeLast()
                }
            }
        }
    }
}