class Solution {
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        var answer = IntArray(query.size)
        val mapInfo = hashMapOf<List<String>, MutableList<Int>>()

        info.asSequence().map { it.split(" ") }.forEach {
            if (mapInfo.containsKey(it.slice(0..3))) {
                mapInfo[it.slice(0..3)]!!.add(it.last().toInt())
            } else {
                mapInfo[it.slice(0..3)] = mutableListOf(it.last().toInt())
            }
        }

        mapInfo.values.forEach { it.sort() }
        
        for (i in query.indices) {
            val queryList = query[i].split(" and ", " ")
            answer[i] = mapInfo.asSequence()
                .filter { if (queryList[0] != "-") it.key.contains(queryList[0]) else true }
                .filter { if (queryList[1] != "-") it.key.contains(queryList[1]) else true }
                .filter { if (queryList[2] != "-") it.key.contains(queryList[2]) else true }
                .filter { if (queryList[3] != "-") it.key.contains(queryList[3]) else true }
                .fold(0) { total, i ->
                    total + calc(i.value, queryList[4].toInt())
                }
        }
        
        return answer
    }

    fun calc(list: List<Int>, num: Int): Int {
        var startIndex = 0
        var lastIndex = list.lastIndex

        while (startIndex <= lastIndex) {
            val index = (startIndex + lastIndex) / 2
            if (list[index] < num) startIndex = index + 1 else lastIndex = index - 1
        }
        return list.lastIndex - startIndex + 1
    }
}