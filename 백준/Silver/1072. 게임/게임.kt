fun main() {
    val (X, Y) = readln().split(" ").map { it.toLong() }
    val startPer = Y * 100 / X
    if (startPer >= 99) {
        println(-1)
        return
    }

    var s = 0L
    var e = Long.MAX_VALUE / 2

    while (s < e) {
        val mid = (s + e) / 2

        val NY = Y + mid
        val NX = X + mid

        if (NY * 100 / NX != startPer) {
            e = mid
        } else {
            s = mid + 1
        }
    }

    println((s + e) / 2)
}