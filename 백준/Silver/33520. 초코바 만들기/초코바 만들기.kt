fun main() {
    val N = readln().toInt()
    var w = 0L
    var h = 0L

    for (i in 0 until N) {
        val (a, b) = readln().split(" ").map { it.toLong() }

        w = maxOf(w, minOf(a, b))
        h = maxOf(h, maxOf(a, b))
    }

    println(w * h)
}