class Solution {
    var answer: Long = 0
    fun solution(weights: IntArray): Long {
        weights.sort()
        calc(weights)
        return answer
    }

    fun calc(list: IntArray, i: Int = 0, count: Long = 0) {
        if (i == list.lastIndex) {
            if (answer < count) answer = count
        } else {
            var result = 0
            val numI = list[i]
            for (j in i + 1..list.lastIndex) {
                val numJ = list[j]
                if (numI == numJ || numI * 4 == numJ * 3 || numI * 4 == numJ * 2 || numI * 3 == numJ * 2) result++
            }
            calc(list, i + 1, count + result)
        }
    }
}