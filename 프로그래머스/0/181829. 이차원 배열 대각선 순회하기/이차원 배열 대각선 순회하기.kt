class Solution {
    fun solution(board: Array<IntArray>, k: Int): Int {
        var answer = 0
        
        for (i in board.indices) {
            for (j in board[0].indices) {
                if (i + j <= k) answer += board[i][j]
            }
        }
        
        return answer
    }
}