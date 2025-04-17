import kotlin.math.abs

fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val (R, C) = readln().split(" ").map { it.toInt() }
        val map = Array(R) { IntArray(C) }

        for (i in 0 until R) {
            val input = readln().split(" ").map { it.toInt() }

            for (j in 0 until C) {
                map[i][j] = input[j]
            }
        }

        for (i in 0 until R) {
            for (j in 0 until C) {
                val a = if (j - 1 < 0) 0 else map[i][j - 1]
                val b = if (i - 1 < 0) 0 else map[i - 1][j]
                val c = if (i - 1 < 0 || j - 1 < 0) 0 else map[i - 1][j - 1]

                var num = 0
                var min = map[i][j]

                if (abs(map[i][j] - a) < abs(min)) {
                    num = 1
                    min = map[i][j] - a
                }

                if (abs(map[i][j] - b) < abs(min)) {
                    num = 2
                    min = map[i][j] - b
                }

                if (abs(map[i][j] - (a + b) / 2) < abs(min)) {
                    num = 3
                    min = map[i][j] - (a + b) / 2
                }

                if (abs(map[i][j] - (a + b - c)) < abs(min)) {
                    num = 4
                    min = map[i][j] - (a + b - c)
                }

                sb.append(num).append(" ").append(min)

                if (j != C - 1) sb.append(" ")
            }

            sb.appendLine()
        }
    }

    print(sb)
}