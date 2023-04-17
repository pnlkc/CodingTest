import kotlin.math.sqrt

class Solution {
    fun solution(r1: Int, r2: Int): Long {
        var answer: Long = 0

        for (i in 1 until r2) {
            val calcR1 = if (i >= r1) 0 to true else calc(i, r1)
            val calcR2 = calc(i, r2)
            answer += calcR2.first - (if (calcR1.second) calcR1.first  - 1 else calcR1.first)
        }

        return (answer + 1) * 4
    }

    fun calc(x: Int, r: Int): Pair<Int, Boolean> {
        val xSquare = (x.toLong() * x)
        val rSquare = (r.toLong() * r)
        val diff = rSquare - xSquare
        val sqrt = sqrt(diff.toDouble()).toLong()
        return sqrt.toInt() to (diff == sqrt * sqrt)
    }
}