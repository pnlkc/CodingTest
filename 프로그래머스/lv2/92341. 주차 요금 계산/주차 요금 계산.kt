class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val mapRecords = records.map { it.split(" ") }.groupBy { it[1] }.toSortedMap()
        val answer = mutableListOf<Int>()
        mapRecords.forEach {
            var time = getTime(it.value)
            if (time <= fees[0]) {
                answer.add(fees[1])
            } else {
                var cost = fees[1]
                time -= fees[0]
                cost += time / fees[2] * fees[3]
                if (time % fees[2] != 0) cost += fees[3]
                answer.add(cost)
            }
        }
        return answer.toIntArray()
    }

    fun getTime(list: List<List<String>>): Int {
        var time = 0
        var start = 0
        var end = 1
        val getInOutTime: (Int) -> Int = { index: Int ->
            list[index][0].split(":").foldIndexed(0) {index, acc, s ->
                when (index) {
                    0 -> acc + s.toInt() * 60
                    else -> acc + s.toInt()
                }
            }
        }

        while (end <= list.lastIndex) {
            val outTime = getInOutTime(end)
            val inTime = getInOutTime(start)
            time += outTime - inTime
            start += 2
            end += 2
        }
        if (list.size % 2 != 0) {
            val inTime = getInOutTime(list.lastIndex)
            time += 1439 - inTime
        }

        return time
    }
}