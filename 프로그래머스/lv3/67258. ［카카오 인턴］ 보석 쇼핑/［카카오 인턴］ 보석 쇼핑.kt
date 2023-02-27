class Solution {
    var answer = intArrayOf(-1, -1)

    fun solution(gems: Array<String>): IntArray {
        val list = gems.mapIndexed { i, s -> s to i }.groupBy { it.first }
            .map { it.key to it.value.map { map -> map.second } }
            .sortedBy { it.second.size }
        val usedList = mutableListOf<Int>()
        val filterList = list.filter { it.second.size == 1 }
        if (filterList.isNotEmpty()) { filterList.forEach { usedList.addAll(it.second) } }
        if (filterList.size == list.size) {
            answer = intArrayOf(1, gems.size)
        } else {
            for (i in list[filterList.size].second) {
                usedList.add(i)
                calc(list, usedList, filterList.size + 1)
                usedList.removeLast()
            }
        }
        return answer
    }

    fun calc(list: List<Pair<String, List<Int>>>, usedList: MutableList<Int>, i: Int = 1) {
        if (i <= list.lastIndex) {
            if (answer[0] == -1 || usedList.maxOrNull()!! - usedList.minOrNull()!! <= answer[1] - answer[0]) {
                val mMUL = intArrayOf(usedList.minOrNull()!!, usedList.maxOrNull()!!)
                val filterList = list[i].second.filter { it in mMUL[0] + 1 until mMUL[1] }
                if (filterList.isEmpty()) {
                    val minL = list[i].second.filter { it < mMUL[0] }.maxOrNull()
                    val maxR = list[i].second.filter { it > mMUL[1] }.minOrNull()
                    if (minL != null) {
                        val temp = usedList.toMutableList()
                        temp.add(minL)
                        calc(list, temp, i + 1)
                    }
                    if (maxR != null) {
                        val temp = usedList.toMutableList()
                        temp.add(maxR)
                        calc(list, temp, i + 1)
                    }
                } else {
                    calc(list, usedList, i + 1)
                }
            }
        } else {
            val min = usedList.minOrNull()!! + 1
            val max = usedList.maxOrNull()!! + 1
            if (answer[0] == -1 || answer[1] - answer[0] > max - min) {
                answer[0] = min
                answer[1] = max
            } else if (answer[1] - answer[0] == max - min) {
                if (min < answer[0]) {
                    answer[0] = min
                    answer[1] = max
                }
            }
        }
    }
}