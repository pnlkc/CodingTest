fun main() {
    // 스도쿠판 만들기
    val array = Array(9) { IntArray(9) }

    // 스도쿠판 채우기
    repeat(9) { num ->
        array[num] = readln().split(" ").map { it.toInt() }.toIntArray()
    }

    // 스도쿠 해결 알고리즘
    solveSudoku(array)

    // 스도쿠판 출력
    array.forEach { println(it.joinToString(" ")) }
}

// 스도쿠 해결 알고리즘
fun solveSudoku(array: Array<IntArray>) : Boolean {
    // 0으로 표시된 자리 검색
    // 0으로 표시된 자리가 없으면 종료
    val zeroPos = findZero(array) ?: return true
    val (y, x) = zeroPos

    // 1..9 까지 대입해보고 스도쿠가 풀리는지 확인
    for (num in 1..9) {
        // 이 부분이 백트래킹하는 코드
        if (check(array, y, x, num)) {
            array[y][x] = num
            if (solveSudoku(array)) return true
            array[y][x] = 0
        }
    }

    // 스도쿠판이 풀리지 않으면 false 리턴
    return false
}

// 0으로 표시된 자리 검색
fun findZero(array: Array<IntArray>): Pair<Int, Int>? {
    for (i in 0..8) {
        for (j in 0..8) {
            if (array[i][j] == 0) return i to j
        }
    }
    // 0이 없으면 null 리턴
    return null
}

// num이 들어갈 수 있는지 확인
fun check(array: Array<IntArray>, y: Int, x: Int, num: Int): Boolean {
    // 가로, 세로 확인
    for (i in 0..8) {
        if (array[y][i] == num || array[i][x] == num) return false
    }

    // 3x3 칸 확인
    for (j in 0..2) {
        for (k in 0..2) {
            if (array[y / 3 * 3 + j][x / 3 * 3 + k] == num) return false
        }
    }

    // 들어갈 수 있으면 true 리턴
    return true
}
