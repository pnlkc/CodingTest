data class Pos(val x: Int, val y: Int)

var map = arrayOf<BooleanArray>()
var list = arrayOf<Array<List<Pos>>>()

fun main() {
    val sb = StringBuilder()
    val k = readln().toInt()
    val command = readln().split(" ")
    val h = readln().toInt()
    var l = 1
    var x = 1
    var y = 1
    repeat(k + 1) {
        l *= 2
        x *= 2
        y *= 2
    }

    map = Array(y) { BooleanArray(x) }
    list = Array(y) { yI -> Array(x) { xI -> listOf(Pos(xI, yI)) } }

    for (str in command) {
        list = calc(str, x, y)
        if (str == "D" || str == "U") y /= 2 else x /= 2
    }

    val tx = if (h == 0 || h == 2) 0 else 1
    val ty = if (h == 0 || h == 1) 0 else 1

    for (pos in list[ty][tx]) {
        map[pos.y][pos.x] = true
    }

    for (i in 0 until l / 2) {
        for (j in 0 until l / 2) {
            if (j != 0) sb.append(" ")
            when {
                map[i * 2][j * 2] -> sb.append(0)
                map[i * 2][j * 2 + 1] -> sb.append(1)
                map[i * 2 + 1][j * 2] -> sb.append(2)
                map[i * 2 + 1][j * 2 + 1] -> sb.append(3)
            }
        }
        sb.appendLine()
    }

    print(sb)
}

fun calc(str: String, x: Int, y: Int): Array<Array<List<Pos>>> {
    val temp: Array<Array<List<Pos>>>

    when (str) {
        "D" -> {
            temp = Array(y / 2) { Array(x) { listOf() } }

            for (i in y / 2 - 1 downTo 0) {
                for (j in 0 until x) {
                    temp[y /2 - 1 - i][j] = list[i][j] + list[y - 1 - i][j]
                }
            }
        }
        "U" -> {
            temp = Array(y / 2) { Array(x) { listOf() } }

            for (i in 0 until y / 2) {
                for (j in 0 until x) {
                    temp[i][j] = list[i][j] + list[y - 1 - i][j]
                }
            }
        }
        "R" -> {
            temp = Array(y) { Array(x / 2) { listOf() } }

            for (i in 0 until y) {
                for (j in x / 2 - 1 downTo 0) {
                    temp[i][x / 2 - 1 - j] = list[i][j] + list[i][x - 1 - j]
                }
            }
        }
        else -> {
            temp = Array(y) { Array(x / 2) { listOf() } }

            for (i in 0 until y) {
                for (j in 0 until x / 2) {
                    temp[i][j] = list[i][j] + list[i][x - 1 - j]
                }
            }
        }
    }

    return temp
}