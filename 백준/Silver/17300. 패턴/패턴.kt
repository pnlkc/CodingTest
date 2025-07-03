fun main() {
    val L = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val isVisit = Array(3) { BooleanArray(3) }
    val map = mutableMapOf(
        1 to (0 to 0), 2 to (0 to 1), 3 to (0 to 2),
        4 to (1 to 0), 5 to (1 to 1), 6 to (1 to 2),
        7 to (2 to 0), 8 to (2 to 1), 9 to (2 to 2),
    )

    if (list.distinct().size != L) {
        println("NO")
        return
    }

    val (sy, sx) = map[list[0]]!!
    isVisit[sy][sx] = true

    for (i in 1 until L) {
        var result = true

        if ((list[i - 1] == 1 && list[i] == 9) || (list[i - 1] == 9 && list[i] == 1)) {
            if (!isVisit[1][1]) result = false
        }

        if ((list[i - 1] == 3 && list[i] == 7) || (list[i - 1] == 7 && list[i] == 3)) {
            if (!isVisit[1][1]) result = false
        }

        for (j in 0..2) {
            if ((list[i - 1] == 1 + j && list[i] == 7 + j) || (list[i - 1] == 7 + j && list[i] == 1 + j)) {
                if (!isVisit[1][j]) result = false
            }
        }

        for (j in 0..2) {
            if ((list[i - 1] == j * 3 + 1 && list[i] == j * 3 + 3) || (list[i - 1] == j * 3 + 3 && list[i] == j * 3 + 1)) {
                if (!isVisit[j][1]) result = false
            }
        }

        if (!result) {
            println("NO")
            return
        }

        val (y, x) = map[list[i]]!!

        isVisit[y][x] = true
    }

    println("YES")
}