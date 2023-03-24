import java.util.*

class Solution {
    fun solution(board: Array<String>): Int {
        val queue = LinkedList<IntArray>()
        val isVisit = Array(board.size) { BooleanArray(board[0].length) { false } }
        val (r, g) = findStartEndPos(board)
        queue.add(intArrayOf(r[0], r[1], 0))

        while (queue.isNotEmpty()) {
            val c = queue.poll()!!
            val y = intArrayOf(1, -1, 0, 0)
            val x = intArrayOf(0, 0, 1, -1)

            for (i in 0..3) {
                val pos = intArrayOf(c[0], c[1], c[2] + 1)

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
                
                // 현재 위치가 목적지면 값 리턴
                if (pos[0] == g[0] && pos[1] == g[1]) return pos[2]
                
                // 방문한 적이 없는 경우 queue에 추가
                if (!isVisit[pos[0]][pos[1]]) {
                    queue.add(pos)
                    isVisit[pos[0]][pos[1]] = true
                }
            }
        }
        
        return -1
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
}