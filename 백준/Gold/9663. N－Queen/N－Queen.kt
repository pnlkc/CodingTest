var n = 0
var count = 0
var board = arrayOf<BooleanArray>()

fun main() {
    n = readln().toInt()
    board = Array(n) { BooleanArray(n) { true } }
    move(0)
    println(count)
}

fun move(c: Int) {
    if (c == n) {
        count++
        return
    }
    
    for (i in 0 until n) {
        if (check(i, c)) {
            board[i][c] = false
            move(c + 1)
            board[i][c] = true
        }
    }
}

fun check(y: Int, x: Int): Boolean {
    for (i in 0 until n) {
        // 가로, 세로 체크
        if (!board[y][i] || !board[i][x]) return false
    }

    for (i in -n + 1 until n) {
        // \ 모양 대각선 체크
        if (y + i in 0 until n && x + i in 0 until n) {
            if (!board[y + i][x + i]) return false
        }
        // / 모양 대각선 체크
        if (y + i in 0 until n && x - i in 0 until n) {
            if (!board[y + i][x - i]) return false
        }
    }

    return true
}