class Solution {
    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        val r = Array(board.size + 1) { IntArray(board[0].size + 1) { 0 } }
        for (s in skill) {
            val n = if (s[0] != 1) s[5] else s[5] * -1
            r[s[1]][s[2]] += n
            r[s[3] + 1][s[2]] += n * -1
            r[s[1]][s[4] + 1] += n * -1
            r[s[3] + 1][s[4] + 1] += n
        }
        
        for (i in 0 until r.lastIndex) {
            for (j in 0 until r[0].lastIndex) {
                r[i][j + 1] += r[i][j]
            }
        }

        for (j in 0 until r[0].lastIndex) {
            for (i in 0 until r.lastIndex) {
                r[i + 1][j] += r[i][j]
            }
        }
        
        for (i in board.indices) {
            for (j in board[0].indices) {
                board[i][j] += r[i][j]
            }
        }

        return board.sumOf { it.count { it > 0 } }
    }
}