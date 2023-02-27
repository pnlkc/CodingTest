class Solution {
    var answer = Int.MAX_VALUE
    var count = arrayOf(arrayOf(arrayOf(intArrayOf())))
    var indices = 0..0

    fun solution(board: Array<IntArray>): Int {
        indices = board.indices
        count = Array(board.size) { Array(board.size) { Array(board.size) { IntArray(board.size) { Int.MAX_VALUE } } } }
        calc(intArrayOf(0, 0), intArrayOf(0, 1), 0, board)
        return answer
    }

    fun calc(a: IntArray, b: IntArray, n: Int, aBoard: Array<IntArray>) {
        if (a[0] == indices.last && a[1] == indices.last) {
            if (answer > n) answer = n
        } else if (b[0] == indices.last && b[1] == indices.last) {
            if (answer > n) answer = n
        } else {
            val move =
                arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
            for (m in move) {
                val newA = intArrayOf(a[0] + m[0], a[1] + m[1])
                if (newA[0] !in indices || newA[1] !in indices) continue
                val newB = intArrayOf(b[0] + m[0], b[1] + m[1])
                if (newB[0] !in indices || newB[1] !in indices) continue
                if (aBoard[newA[0]][newA[1]] == 1) continue
                if (aBoard[newB[0]][newB[1]] == 1) continue

                if (count[newA[0]][newA[1]][newB[0]][newB[1]] > n + 1) {
                    count[newA[0]][newA[1]][newB[0]][newB[1]] = n + 1
                    count[newB[0]][newB[1]][newA[0]][newA[1]] = n + 1
                    calc(newA, newB, n + 1, aBoard)
                }
            }

            val rotate = intArrayOf(1, -1)
            when {
                a[0] == b[0] -> {
                    for (r in rotate) {
                        val newY = a[0] + r
                        if (newY !in indices) continue
                        if (aBoard[newY][a[1]] == 1 || aBoard[newY][b[1]] == 1) continue

                        if (count[a[0]][a[1]][newY][a[1]] > n + 1) {
                            count[a[0]][a[1]][newY][a[1]] = n + 1
                            count[newY][a[1]][a[0]][a[1]] = n + 1
                            calc(a, intArrayOf(newY, a[1]), n + 1, aBoard)
                        }

                        if (count[b[0]][b[1]][newY][b[1]] > n + 1) {
                            count[b[0]][b[1]][newY][b[1]] = n + 1
                            count[newY][b[1]][b[0]][b[1]] = n + 1
                            calc(intArrayOf(newY, b[1]), b, n + 1, aBoard)
                        }
                    }
                }
                a[1] == b[1] -> {
                    for (r in rotate) {
                        val newX = a[1] + r
                        if (newX !in indices) continue
                        if (aBoard[a[0]][newX] == 1 || aBoard[b[0]][newX] == 1) continue

                        if (count[a[0]][a[1]][a[0]][newX] > n + 1) {
                            count[a[0]][a[1]][a[0]][newX] = n + 1
                            count[a[0]][newX][a[0]][a[1]] = n + 1
                            calc(a, intArrayOf(a[0], newX), n + 1, aBoard)
                        }

                        if (count[b[0]][b[1]][b[0]][newX] > n + 1) {
                            count[b[0]][b[1]][b[0]][newX] = n + 1
                            count[b[0]][newX][b[0]][b[1]] = n + 1
                            calc(intArrayOf(b[0], newX), b, n + 1, aBoard)
                        }
                    }
                }
            }
        }
    }
}