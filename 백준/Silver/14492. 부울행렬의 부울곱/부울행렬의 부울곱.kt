fun main() {
    val N = readln().toInt()
    val a = Array(N) { IntArray(N) }
    val b = Array(N) { IntArray(N) }
    val c = Array(N) { IntArray(N) }
    var cnt = 0

    for (i in 0 until N) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until N) {
            a[i][j] = input[j]
        }
    }

    for (i in 0 until N) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until N) {
            b[i][j] = input[j]
        }
    }

    for (i in 0 until N) {
        for (j in 0 until N) {
            for (k in 0 until N) {
                c[i][j] = c[i][j].or(a[i][k].and(b[k][j]))
            }

            if (c[i][j] == 1) cnt++
        }
    }

    println(cnt)
}