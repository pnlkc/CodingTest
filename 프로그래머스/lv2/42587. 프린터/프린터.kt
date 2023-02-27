class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        val numList = mutableListOf<Int>()
        for (i in priorities.indices) {
            numList.add(i)
        }
        val mapList = numList.mapIndexed { index, _ -> numList[index] to priorities[index] }.toMap()
            .toMutableMap()
        val target = mapList[location]
        var max = mapList.values.maxOrNull()

        loop@while (true) {
            for (i in mapList.keys.toList()) {
                if (mapList[i] == max) {
                    val temp = mapList[i]
                    mapList.remove(i)
                    max = mapList.values.maxOrNull()
                    if (i == location && temp == target) break@loop
                } else {
                    val temp = mapList[i]
                    mapList.remove(i)
                    mapList[i] = temp!!
                }
            }
        }

        return priorities.size - mapList.size
    }
}