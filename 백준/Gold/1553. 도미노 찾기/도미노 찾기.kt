val map = Array(8) { IntArray(7) }
val domino = initDomino().toMutableMap()
val isVisit = Array(8) { BooleanArray(7) }
var result = 0

fun main() {
    for (i in 0 until 8) {
        val str = readln()

        for (j in 0 until 7) {
            map[i][j] = str[j].digitToInt()
        }
    }

    calc(0, 0, 0)

    println(result)
}

fun initDomino() = listOf(
    0 to 0, 0 to 1, 0 to 2, 0 to 3,
    0 to 4, 0 to 5, 0 to 6, 1 to 1,
    1 to 2, 1 to 3, 1 to 4, 1 to 5,
    1 to 6, 2 to 2, 2 to 3, 2 to 4,
    2 to 5, 2 to 6, 3 to 3, 3 to 4,
    3 to 5, 3 to 6, 4 to 4, 4 to 5,
    4 to 6, 5 to 5, 5 to 6, 6 to 6
).associateWith { false }

fun calc(x: Int, y: Int, cnt: Int) {
    if (cnt == 28 || (x == 6 && y == 7)) {
        for (i in 0 until 8) {
            for (j in 0 until 7) {
                if (!isVisit[i][j]) return
            }
        }

        result++
        return
    }

    if (!isVisit[y][x]) {
        if (y + 1 < 8 && !isVisit[y + 1][x]) {
            val min = minOf(map[y][x], map[y + 1][x])
            val max = maxOf(map[y][x], map[y + 1][x])

            if (!domino[min to max]!!) {
                isVisit[y][x] = true
                isVisit[y + 1][x] = true
                domino[min to max] = true

                if (x + 1 == 7) {
                    calc(0, y + 1, cnt + 1)
                } else {
                    calc(x + 1, y, cnt + 1)
                }


                isVisit[y][x] = false
                isVisit[y + 1][x] = false
                domino[min to max] = false
            }
        }

        if (x + 1 < 7 && !isVisit[y][x + 1]) {
            val min = minOf(map[y][x], map[y][x + 1])
            val max = maxOf(map[y][x], map[y][x + 1])

            if (!domino[min to max]!!) {
                isVisit[y][x] = true
                isVisit[y][x + 1] = true
                domino[min to max] = true

                if (x + 2 == 7) {
                    calc(0, y + 1, cnt + 1)
                } else {
                    calc(x + 2, y, cnt + 1)
                }

                isVisit[y][x] = false
                isVisit[y][x + 1] = false
                domino[min to max] = false
            }
        }
    } else {
        if (x == 6 && y + 1 < 8) {
            calc(0, y + 1, cnt)
        } else if (x < 6) {
            calc(x + 1, y, cnt)
        }
    }
}