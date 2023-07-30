import kotlin.system.exitProcess

fun main() {
    val board = Array(9) { IntArray(9) }
    val zeroList = mutableListOf<Pair<Int, Int>>()

    for (i in 0 until 9) {
        val input = readln().toCharArray().map(Char::digitToInt)
        for (j in 0 until 9) {
            if (input[j] != 0) board[i][j] = input[j] else zeroList.add(i to j)
        }
    }

    bt(0, zeroList, board)
}

fun bt(idx: Int, zeroList: MutableList<Pair<Int, Int>>, board: Array<IntArray>) {
    if (idx == zeroList.size) {
        board.forEach { println(it.joinToString("")) }
        exitProcess(0)
    } else {
        val (y, x) = zeroList[idx]
        val cl = check(board, y, x)
        for (i in 1..9) {
            if (cl[i]) continue
            board[y][x] = i
            bt(idx + 1, zeroList, board)
            board[y][x] = 0
        }
    }
}

fun check(board: Array<IntArray>, y: Int, x: Int): BooleanArray {
    val list = BooleanArray(10)

    for (i in 0 until 9) {
        list[board[y][i]] = true
        list[board[i][x]] = true
    }

    for (i in y / 3 * 3..y / 3 * 3 + 2) {
        for (j in x / 3 * 3.. x / 3 * 3 + 2) {
            list[board[i][j]] = true
        }
    }

    return list
}