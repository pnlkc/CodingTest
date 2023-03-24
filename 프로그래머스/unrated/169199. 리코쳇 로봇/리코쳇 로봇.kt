class Solution {
    fun solution(board: Array<String>): Int {
        val map = mutableMapOf<String, Int>()
        val (r, g) = findStartEndPos(board)
        move(r, g, board, map, 0)
        return map["${g[0]} ${g[1]}"] ?: -1
    }

    // 시작, 목표 위치 찾기
    fun findStartEndPos(board: Array<String>): Pair<IntArray, IntArray> {
        var r: IntArray? = null
        var g: IntArray? = null
        for (i in board.indices) {
            for (j in board[0]. indices) {
                if (board[i][j] == 'R') r = intArrayOf(i, j)
                if (board[i][j] == 'G') g = intArrayOf(i, j)
                if (r != null && g != null) return r to g
            }
        }

        return intArrayOf() to intArrayOf()
    }

    fun move(c: IntArray, g: IntArray, board: Array<String>, map: MutableMap<String, Int>, n: Int) {
        if (map["${g[0]} ${g[1]}"] != null && map["${g[0]} ${g[1]}"]!! < n) return
        if (c[0] != g[0] || c[1] != g[0]) {
            val y = intArrayOf(1, -1, 0, 0)
            val x = intArrayOf(0, 0, 1, -1)

            for (i in 0..3) {
                val pos = c.clone()

                // 벽이나 장애물 전까지 이동
                while (true) {
                    if (pos[0] + y[i] !in board.indices) break
                    if (pos[1] + x[i] !in board[0].indices) break
                    if (board[pos[0] + y[i]][pos[1] + x[i]] == 'D') break

                    pos[0] += y[i]
                    pos[1] += x[i]
                }

                // 같은 자리일 경우 제외
                if (pos[0] == c[0] && pos[1] == c[1]) continue
                
                // 같은 자리를 더 빨리 오는 경우 제외
                if (map["${pos[0]} ${pos[1]}"] == null || map["${pos[0]} ${pos[1]}"]!! > n + 1) {
                    map["${pos[0]} ${pos[1]}"] = n + 1
                    move(pos, g, board, map, n + 1)
                }
            }
        }
    }
}