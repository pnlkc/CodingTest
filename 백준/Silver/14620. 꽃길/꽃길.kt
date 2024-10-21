val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)
var map = arrayOf<IntArray>()
var isVisit = arrayOf<BooleanArray>()
var result = Int.MAX_VALUE

fun main() {
    val N = readln().toInt()
    map = Array(N) { IntArray(N) }
    isVisit = Array(N) { BooleanArray(N) }

    for (i in 0 until N) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until N) {
            map[i][j] = input[j]
        }
    }

    pick(0, N, 0)

    println(result)
}

fun pick(idx: Int, N: Int, sum: Int) {
    if (idx >= 3) {
        result = minOf(result, sum)
        return
    }

    for (i in 1 until N - 1) {
        for (j in 1 until N - 1) {
            val temp = canPick(j, i, N)
            
            if (temp != -1) {
                isVisit[i][j] = true

                for (d in 0..3) {
                    isVisit[i + dy[d]][j + dx[d]] = true
                }

                pick(idx + 1, N, sum + temp)

                isVisit[i][j] = false

                for (d in 0..3) {
                    isVisit[i + dy[d]][j + dx[d]] = false
                }
            }
        }
    }
}

fun canPick(x: Int, y: Int, N: Int): Int {
    if (isVisit[y][x]) return -1

    var sum = map[y][x]

    for (d in 0..3) {
        val nx = x + dx[d]
        val ny = y + dy[d]

        if (isVisit[ny][nx]) return -1

        sum += map[ny][nx]
    }

    return sum
}