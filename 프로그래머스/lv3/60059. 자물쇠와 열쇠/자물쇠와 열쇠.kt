class Solution {
    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        val zeroList = makeZeroList(lock)
        var rKey = key
        var answer = check(makeOneList(rKey), zeroList)
        if (!answer) {
            for (i in 1..3) {
                rKey = rotate(rKey)
                answer = check(makeOneList(rKey), zeroList)
                if (answer) break
            }
        }
        return answer
    }

    private fun makeZeroList(lock: Array<IntArray>): MutableList<String> {
        val result = mutableListOf<String>()
        for (i in lock.indices) {
            for (j in lock.indices) {
                if (lock[i][j] == 0) result.add("$i $j")
            }
        }
        return result
    }

    private fun makeOneList(key: Array<IntArray>): MutableList<String> {
        val result = mutableListOf<String>()
        for (i in key.indices) {
            for (j in key.indices) {
                if (key[i][j] == 1) result.add("$i $j")
            }
        }
        return result
    }

    private fun rotate(key: Array<IntArray>): Array<IntArray> {
        val temp = Array(key.size) { IntArray(key.size) { 0 } }
        for (i in key.lastIndex downTo 0) {
            for (j in key.indices) {
                temp[j][key.lastIndex - i] = key[i][j]
            }
        }
        return temp
    }

    private fun check(keyList: List<String>, lockList: List<String>): Boolean {
        val temp = lockList.map {
            val first = lockList[0].split(" ")
            val split = it.split(" ")
            "${first[0].toInt() - split[0].toInt()} ${first[1].toInt() - split[1].toInt()}"
        }
        
        if (temp.isEmpty()) return true
        
        val range = intArrayOf(0, 0, 0, 0)
        range[0] = temp.minOf { it.split(" ")[0].toInt() }
        range[1] = temp.maxOf { it.split(" ")[0].toInt() }
        range[2] = temp.minOf { it.split(" ")[1].toInt() }
        range[3] = temp.maxOf { it.split(" ")[1].toInt() }

        p1@for (key in keyList) {
            val compare = keyList.map {
                val first = key.split(" ")
                val split = it.split(" ")
                "${first[0].toInt() - split[0].toInt()} ${first[1].toInt() - split[1].toInt()}"
            }
            if (compare.containsAll(temp)) {
                val left = compare - temp
                for (l in left) {
                    val num = l.split(" ").map { it.toInt() }
                    if (num[0] in range[0]..range[1] && num[1] in range[2]..range[3]) continue@p1
                }
                return true
            }
        }

        return false
    }
}