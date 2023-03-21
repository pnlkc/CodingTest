fun main() {
    val num = readln().toInt()
    var xL = intArrayOf(10000, -10000)
    var yL = intArrayOf(10000, -10000)

    repeat(num) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        xL = intArrayOf(minOf(xL[0], x), maxOf(xL[1], x))
        yL = intArrayOf(minOf(yL[0], y), maxOf(yL[1], y))
    }

    println((xL[1] - xL[0]) * (yL[1] - yL[0]))
}