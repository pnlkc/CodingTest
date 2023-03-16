fun main() {
    val array = Array(9) { IntArray(9) }

    repeat(9) { num ->
        array[num] = readln().split(" ").map { it.toInt() }.toIntArray()
    }

    solveSudoku(array)

    array.forEach { println(it.joinToString(" ")) }
}

fun solveSudoku(array: Array<IntArray>) : Boolean {
    val zeroPos = findZero(array) ?: return true
    val (y, x) = zeroPos

    for (num in 1..9) {
        if (check(array, y, x, num)) {
            array[y][x] = num
            if (solveSudoku(array)) return true
            array[y][x] = 0
        }
    }

    return false
}

fun findZero(array: Array<IntArray>): Pair<Int, Int>? {
    for (i in 0..8) {
        for (j in 0..8) {
            if (array[i][j] == 0) return i to j
        }
    }
    return null
}

fun check(array: Array<IntArray>, y: Int, x: Int, num: Int): Boolean {
    for (i in 0..8) {
        if (array[y][i] == num || array[i][x] == num) return false
    }

    for (j in 0..2) {
        for (k in 0..2) {
            if (array[y / 3 * 3 + j][x / 3 * 3 + k] == num) return false
        }
    }

    return true
}