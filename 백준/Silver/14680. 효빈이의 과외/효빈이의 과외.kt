fun readlnSpitToInt() = readln().trim().split(" ").map { it.toInt() }

fun main() {
    val N = readln().toInt()
    var (x, y) = readlnSpitToInt()
    var matrix = Array(x) { LongArray(y) }
    val NUM = 1_000_000_007

    for (i in 0 until x) {
        val input = readlnSpitToInt()

        for (j in 0 until y) {
            matrix[i][j] = input[j].toLong()
        }
    }

    for (i in 1 until N) {
        val (nx, ny) = readlnSpitToInt()
        val tMatrix = Array(nx) { LongArray(ny) }

        for (j in 0 until nx) {
            val input = readlnSpitToInt()

            for (k in 0 until ny) {
                tMatrix[j][k] = input[k].toLong()
            }
        }

        if (y != nx) {
            println(-1)
            return
        }

        val temp = Array(x) { LongArray(ny) }

        for (j in 0 until x) {

            for (k in 0 until ny) {
                for (l in 0 until y) {
                    temp[j][k] += matrix[j][l] * tMatrix[l][k]
                    temp[j][k] = temp[j][k] % NUM
                }
            }
        }

        matrix = temp
        y = ny
    }

    var result = 0L

    for (i in 0 until x) {
        for (j in 0 until y) {
            result += matrix[i][j]
            result %= NUM
        }
    }

    println(result)
}