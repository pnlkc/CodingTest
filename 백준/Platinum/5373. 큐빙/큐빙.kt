var cube = arrayOf<CharArray>()

fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 0 until T) {
        init()

        val n = readln().toInt()
        val command = readln().split(" ")

        for (i in 0 until n) {
            repeat(if (command[i][1] == '+') 1 else 3) {
                rotate(command[i][0])
                rotateDiv(command[i][0])
            }
        }

        for (i in 3..5) {
            for (j in 3..5) {
                sb.append(cube[i][j])
            }

            sb.appendLine()
        }
    }

    print(sb)
}

fun init() {
    cube = Array(12) { CharArray(9) }

    for (i in 0..2) {
        for (j in 3..5) {
            cube[i][j] = 'o'
        }
    }

    for (i in 3..5) {
        for (j in 3..5) {
            cube[i][j] = 'w'
        }
    }

    for (i in 6..8) {
        for (j in 3..5) {
            cube[i][j] = 'r'
        }
    }

    for (i in 9..11) {
        for (j in 3..5) {
            cube[i][j] = 'y'
        }
    }

    for (i in 3..5) {
        for (j in 0..2) {
            cube[i][j] = 'g'
        }
    }

    for (i in 3..5) {
        for (j in 6..8) {
            cube[i][j] = 'b'
        }
    }
}

fun rotate(dir: Char) {
    var temp: CharArray

    when (dir) {
        'U' -> {
            temp = charArrayOf(cube[3][2], cube[4][2], cube[5][2])
            (0..2).forEach { cube[3 + it][2] = cube[6][3 + it] }
            (0..2).forEach { cube[6][3 + it] = cube[5 - it][6] }
            (0..2).forEach { cube[5 - it][6] = cube[2][5 - it] }
            (0..2).forEach { cube[2][5 - it] = temp[it] }
        }

        'D' -> {
            temp = charArrayOf(cube[8][3], cube[8][4], cube[8][5])
            (0..2).forEach { cube[8][3 + it] = cube[3 + it][0] }
            (0..2).forEach { cube[3 + it][0] = cube[0][5 - it] }
            (0..2).forEach { cube[0][5 - it] = cube[5 - it][8] }
            (0..2).forEach { cube[5 - it][8] = temp[it] }
        }

        'F' -> {
            temp = charArrayOf(cube[5][3], cube[5][4], cube[5][5])
            (0..2).forEach { cube[5][3 + it] = cube[5][it] }
            (0..2).forEach { cube[5][it] = cube[9][5 - it] }
            (0..2).forEach { cube[9][3 + it] = cube[5][8 - it] }
            (0..2).forEach { cube[5][6 + it] = temp[it] }
        }

        'B' -> {
            temp = charArrayOf(cube[3][3], cube[3][4], cube[3][5])
            (0..2).forEach { cube[3][5 - it] = cube[3][8 - it] }
            (0..2).forEach { cube[3][8 - it] = cube[11][3 + it] }
            (0..2).forEach { cube[11][3 + it] = cube[3][2 - it] }
            (0..2).forEach { cube[3][2 - it] = temp[2 - it] }
        }

        'L' -> {
            temp = charArrayOf(cube[3][3], cube[4][3], cube[5][3])
            (0..2).forEach { cube[3 + it][3] = cube[it][3] }
            (0..2).forEach { cube[it][3] = cube[9 + it][3] }
            (0..2).forEach { cube[9 + it][3] = cube[6 + it][3] }
            (0..2).forEach { cube[6 + it][3] = temp[it] }
        }

        'R' -> {
            temp = charArrayOf(cube[3][5], cube[4][5], cube[5][5])
            (0..2).forEach { cube[3 + it][5] = cube[6 + it][5] }
            (0..2).forEach { cube[6 + it][5] = cube[9 + it][5] }
            (0..2).forEach { cube[9 + it][5] = cube[it][5] }
            (0..2).forEach { cube[it][5] = temp[it] }
        }
    }
}

fun rotateDiv(dir: Char) {
    var x = 0
    var y = 0

    when (dir) {
        'U' -> {
            x = 3
            y = 3
        }
        'D' -> {
            x = 3
            y = 9
        }
        'F' -> {
            x = 3
            y = 6
        }
        'B' -> {
            x = 3
            y = 0
        }
        'L' -> {
            x = 0
            y = 3
        }
        'R' -> {
            x = 6
            y = 3
        }
    }

    val temp = charArrayOf(cube[y][x], cube[y][x + 1], cube[y][x + 2])

    (0..2).forEach { cube[y][x + it] = cube[y + 2 - it][x] }
    (0..2).forEach { cube[y + it][x] = cube[y + 2][x + it] }
    (0..2).forEach { cube[y + 2][x + it] = cube[y + 2 - it][x + 2] }
    (0..2).forEach { cube[y + it][x + 2] = temp[it] }
}