fun main() {
    val N = readln().toInt()
    var t1 = 0
    var t2 = 0
    var r = 0

    for (i in 1..N) {
        val (d, v) = readln().split(" ").map { it.toInt() }

        t1 += v

        if (t2 < t1) {
            r += t1 - t2
            t2 = t1 + d
        } else {
            t2 += d
        }
    }

    println(r)
}