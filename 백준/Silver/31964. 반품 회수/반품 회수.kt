fun main() {
    val N = readln().toInt()
    val xL = readln().split(" ").map { it.toInt() }
    val tL = readln().split(" ").map { it.toInt() }

    var time = maxOf(xL.last(), tL.last())

    for (i in N - 2 downTo 0) {
        time += xL[i + 1] - xL[i]

        if (tL[i] > time) time = tL[i]
    }

    time += xL[0]

    println(time)
}