class Solution {
    fun solution(board: Array<String>) = hasFault(board)

    private fun isWin(board: Array<String>, player: Char): Boolean {
        // 대각선
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true

        for (i in 0..2) {
            // 가로
            if (board[i].count { it == player } == 3) return true

            // 세로
            var count = 0
            for (j in 0..2) {
                if (board[j][i] == player) count++
            }
            if (count == 3) return true
        }

        return false
    }

    private fun hasFault(board: Array<String>): Int {
        // O, X 갯수가 맞지 않는 경우
        val count = intArrayOf(0, 0)
        for (i in board.indices) {
            for (j in board[0].indices) {
                when (board[i][j]) {
                    'O' -> count[0]++
                    'X' -> count[1]++
                }
            }
        }
        if (count[0] !in count[1]..count[1] + 1) return 0

        // 게임이 끝났는데 진행한 경우
        val isEnd = booleanArrayOf(isWin(board, 'O'), isWin(board, 'X'))
        if (isEnd.count { it } == 2) return 0

        // O가 이겼는데 갯수가 안맞는 경우
        if (isEnd[0] && count[0] != count[1] + 1) return 0

        // X가 이겼는데 갯수가 안맞는 경우
        if (isEnd[1] && count[0] != count[1]) return 0

        return 1
    }
}