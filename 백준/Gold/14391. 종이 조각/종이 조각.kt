var map = arrayOf<CharArray>()
var result = 0
var mode = arrayOf<IntArray>()

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    map = Array(N) { CharArray(M) }
    mode = Array(N) { IntArray(M) }

    for (i in 0 until N) {
        val str = readln()

        for (j in 0 until M) {
            map[i][j] = str[j]
        }
    }

    calc(0, 0, N, M)

    println(result)
}

fun calc(x: Int, y: Int, n: Int, m: Int) {
    if (y == n) {
        sum(n, m)
        return
    }

    if (x == m) {
        calc(0, y + 1, n, m)
        return
    }

    for (i in 1..2) {
        mode[y][x] = i
        calc(x + 1, y, n, m)
    }

    mode[y][x] = 0
}

fun sum(n: Int, m: Int) {
    var sum = 0

    for (i in 0 until n) {
        var str = "0"

        for (j in 0 until m) {
            if (mode[i][j] == 2) {
                str += map[i][j]
            } else {
                sum += str.toInt()
                str = "0"
            }
        }

        sum += str.toInt()
    }

    for (i in 0 until m) {
        var str = "0"

        for (j in 0 until n) {
            if (mode[j][i] == 1) {
                str += map[j][i]
            } else {
                sum += str.toInt()
                str = "0"
            }
        }

        sum += str.toInt()
    }

    result = maxOf(result, sum)
}