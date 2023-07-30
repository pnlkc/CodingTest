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

fun bt(idx: Int, zeroList: MutableList<Pair<Int, Int>>, board: Array<IntArray>): Boolean {
    if (idx == zeroList.size) {
        // 스도쿠 완성시 출력 후 true를 리턴 하여 더 이상 탐색하지 않도록 설정
        board.forEach { println(it.joinToString("")) }
        return true
    } else {
        val (y, x) = zeroList[idx]
        val list = check(board, y, x) // 입력 가능한 숫자 리스트
        if (list.isEmpty()) return false // 입력 가능한 숫자가 없으면 false 리턴
        list.forEach {
            board[y][x] = it
            if (!bt(idx + 1, zeroList, board)) {
                // 스도쿠 완성이 불가능한 경우 원래대로 복구
                board[y][x] = 0
            } else {
                // 스도쿠 완성이 된 경우 그대로 유지
                return true
            }
        }
        // 모든 숫자를 입력했는데 스도쿠 완성이 안된 것이므로 false 리턴
        return false
    }
}

// 해당 칸에 입력 가능한 숫자 확인
fun check(board: Array<IntArray>, y: Int, x: Int): MutableList<Int> {
    val list = (1..9).toMutableList()

    // 가로 세로 검사
    for (i in 0 until 9) {
        list.remove(board[y][i])
        list.remove(board[i][x])
    }

    // 포함된 9칸 검사
    for (i in y / 3 * 3..y / 3 * 3 + 2) {
        for (j in x / 3 * 3.. x / 3 * 3 + 2) {
            list.remove(board[i][j])
        }
    }

    return list
}