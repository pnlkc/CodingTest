class Solution {
    var answer = 0
    fun solution(n: Int, edge: Array<IntArray>): Int {
        calc(edge.toMutableList())
        return answer
    }

    fun calc(
        edge: MutableList<IntArray>,
        usedList: MutableList<Int> = mutableListOf(1),
        scanRange: IntRange = 0..0,
    ) {
        val temp = edge.toMutableList()
        val lastIndex = usedList.lastIndex
        val sliceList = usedList.slice(scanRange)
        var count = 0
        for (i in edge) {
            when {
                sliceList.contains(i[1]) && !usedList.contains(i[0]) -> {
                    count++
                    usedList.add(i[0])
                    temp.remove(i)
                }
                sliceList.contains(i[0]) && !usedList.contains(i[1]) -> {
                    count++
                    usedList.add(i[1])
                    temp.remove(i)
                }
            }
        }
        if (count != 0) {
            answer = count
            calc(temp, usedList, lastIndex + 1..usedList.lastIndex)
        }
    }
}