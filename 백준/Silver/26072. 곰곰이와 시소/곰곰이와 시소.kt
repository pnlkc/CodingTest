fun main() {
    val (N, L) = readln().split(" ").map { it.toInt() }
    val xL = readln().split(" ").map { it.toInt() }
    val wL = readln().split(" ").map { it.toInt() }
    var top = 0L
    var bot = 0L

    for (i in 0 until N) {
        top += xL[i].toLong() * wL[i]
        bot += wL[i]
    }

    println(top.toDouble() / bot)
}