class Solution {
    fun solution(board: Array<IntArray>): Int {
        val map = Array(board.size) { BooleanArray(board.size) { true } }
        for (i in board.indices) {
            for (j in board.indices) {
                if (board[i][j] == 1) {
                    val xList = mutableListOf(0)
                    if (j + 1 in board.indices) xList.add(1)
                    if (j - 1 in board.indices) xList.add(-1)
                    val yList = mutableListOf(0)
                    if (i + 1 in board.indices) yList.add(1)
                    if (i - 1 in board.indices) yList.add(-1)

                    for (x in xList) {
                        for (y in yList) {
                            map[i + y][j + x] = false
                        }
                    }
                }
            }
        }
        return map.sumOf { array -> array.count { it } }
    }
}