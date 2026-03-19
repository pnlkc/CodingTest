fun main() {
    val (m, n) = readln().split(" ").map { it.toInt() }
    val map = Array(5 * m + 1) { CharArray(5 * n + 1) }
    val result = IntArray(5)

    for (i in 0..5 * m) {
        map[i] = readln().toCharArray()
    }

    for (i in 1..5 * m step 5) {
        for (j in 1..5 * n step 5) {
            var cnt = 0

            for (k in 0..3) {
                if (map[i + k][j] == '*') cnt++
            }

            result[cnt]++
        }
    }

    println(result.joinToString(" "))
}