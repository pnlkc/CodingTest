fun main() {
    val N = readln().toInt()
    val aL = readln().split(" ").map { it.toDouble() }.sorted()
    val avg = aL.average()
    val mid = if (N >= 2) aL[N - 2] else aL[0]

    println(String.format("%.6f", maxOf(avg, mid)))
}