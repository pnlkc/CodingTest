class Solution {
    fun solution(a: Int, b: Int, g: IntArray, s: IntArray, w: IntArray, t: IntArray): Long {
        var min = 0L
        var max = 399_999_999_900_000

        while (min < max) {
            val avg = (min + max) / 2
            val r = longArrayOf(0, 0, 0)
            var result = false
            for (i in g.indices) {
                val n = if (avg / t[i] % 2 != 0L) avg / t[i] / 2 + 1 else avg / t[i] / 2
                val maxI = n * w[i]
                r[0] += minOf(maxI, g[i].toLong() + s[i].toLong())
                r[1] += minOf(maxI, g[i].toLong())
                r[2] += minOf(maxI, s[i].toLong())
                if (a + b <= r[0] && a <= r[1] && b <= r[2]) {
                    result = true
                    break
                }
            }
            if (result) max = avg else min = avg + 1
        }

        return max
    }
}