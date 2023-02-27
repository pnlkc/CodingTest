class Solution {
    var answer = -1
    fun solution(a: IntArray): Int {
        if (a.size == 1) return 0
        val count = IntArray(a.size) { 0 }
        a.forEach { count[it]++ }
        val list = count.mapIndexed { index, i -> index to i }.sortedByDescending { it.second }

        for (i in list) {
            if (i.second == 0) continue
            if (i.second < answer) continue
            val result = mutableListOf(-1)
            for (j in a.indices) {
                if (i.first == a[j]) result.add(j)
            }

            if (i.second == 1) {
                if (answer < 2) answer = 2
                continue
            }

            result.add(a.lastIndex + 1)
            val n = calc(result)
            if (result.size - 2 - n > answer) answer = result.size - 2 - n
        }
        return answer * 2
    }

    fun calc(result: MutableList<Int>): Int {
        var count = 0
        val exR = booleanArrayOf(false, result[0] + 1 != result[1])
        val r = booleanArrayOf(false, false)
        var noChoice = false
        for (i in 0..result.lastIndex - 2) {
            val a = intArrayOf(result[i], result[i + 1], result[i + 2])
            r[0] = exR[1]
            r[1] = a[1] + 1 != a[2]
            if (!r[0] && !r[1]) count++
            if (r[0] && a[1] - a[0] < 3 && a[0] != -1 && !exR[0] && !r[1]) count++
            if (noChoice && !r[1]) count++
            noChoice = if (a[2] - a[1] == 2 && a[1] - a[0] == 2) { !exR[0] || noChoice } else false
            exR[0] = r[0]
            exR[1] = r[1]
        }
        return count
    }
}