class Solution {
    var answer = Int.MAX_VALUE

    fun solution(storey: Int): Int {
        val a = intArrayOf(0) + storey.toString().map { it.toString().toInt() }
        calc(a, a.lastIndex)
        return answer
    }

    fun calc(a: IntArray, i: Int, result: Int = 0) {
        if (result < answer) {
            if (i == 0) {
                if (answer > result + minOf(a[0], 11 - a[0])) answer = result + minOf(a[0], 11 - a[0])
            } else {
                val a1 = a.clone()
                a1[i - 1]++
                calc(a1, i - 1, result + 10 - a1[i])
                calc(a, i - 1, result + a[i])
            }
        }
    }
}