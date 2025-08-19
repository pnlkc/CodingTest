fun main() {
    val N = readln().toInt()
    val aL = readln().split(" ").map { it.toInt() }.sorted()
    val bL = readln().split(" ").map { it.toInt() }.sorted()
    var cnt = 0

    for (i in 0 ..N / 2) {
        if (aL[i] < bL[N / 2 + i]) cnt++
    }

    println(if (cnt >= (N + 1) / 2) "YES" else "NO")
}