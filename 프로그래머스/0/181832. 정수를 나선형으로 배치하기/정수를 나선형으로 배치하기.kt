class Solution {
    fun solution(n: Int): Array<IntArray> {
        val answer =  Array(n) { IntArray(n) }
        val dx = arrayOf(1, 0, -1, 0)
        val dy = arrayOf(0, 1, 0, -1)
        var x = 0
        var y = 0
        var num = 1
        var c = n

        while (num <= n * n) {
            for (d in 0 until 4) {
                for (i in 0 until c) {
                    answer[y + dy[d] * i][x + dx[d] * i] = num++
                }

                y += dy[d] * (c - 1)
                x += dx[d] * (c - 1)

                when (d) {
                    0 -> {
                        y++
                        c--
                    }
                    1 -> x--
                    2 -> {
                        y--
                        c--
                    }
                    3 -> x++
                }
            }
        }

        return answer
    }
}