class Solution {
    fun solution(n: Int): Array<IntArray> {
        val answer =  Array(n) { IntArray(n) }
        var x = 0
        var y = 0
        var num = 1
        var c = n

        while (num <= n * n) {
            repeat(c) {
                answer[y][x++] = num++
            }

            c--
            x--
            y++

            repeat(c) {
                answer[y++][x] = num++
            }

            y--
            x--

            repeat(c) {
                answer[y][x--] = num++
            }

            x++
            y--
            c--

            repeat(c) {
                answer[y--][x] = num++
            }

            y++
            x++
        }

        return answer
    }
}