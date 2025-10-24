fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val nL = readln().split(" ").map { it.toInt() }
    val mL = readln().split(" ").map { it.toInt() - 1 }
    val status = IntArray(N)
    val check = IntArray(N)

    for (i in 0 until M) {
        val c = mL[i]

        if (status[c] + nL[c] < i + 1 || (status[c] != i && check[c] == 1)) check[c] = 2
        status[c] = i + 1
        check[c] = maxOf(0, check[c] - 1)
    }

    for (i in 0 until N) {
        if (status[i] + nL[i] < M + 1 || (status[i] != M && check[i] == 1)) check[i] = 2
    }

    println(check.count { it != 0 })
}