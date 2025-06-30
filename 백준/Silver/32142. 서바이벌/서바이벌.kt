data class Pos(val x: Int, val y: Int)

fun main() {
    val N = readln().toInt()
    val arr = Array(N) { Pos(0, 0) }

    for (i in 0 until N) {
        readln().split(" ").map { it.toInt() }.run { arr[i] = Pos(this[0], this[1]) }
    }

    println(-1)
}