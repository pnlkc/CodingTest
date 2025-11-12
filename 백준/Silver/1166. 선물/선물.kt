fun main() {
    val (N, L, W, H) = readln().split(" ").map { it.toInt() }
    var s = 0.0
    var e = 1_000_000_000.0
    var result = 0.0

    while (s <= e) {
        val m = (s + e) / 2
        val r = (L / m).toLong() * (W / m).toLong() * (H / m).toLong()
        
        if (s == m || e == m) break

        if (r >= N) {
            result = maxOf(result, m)
            s = m
        } else {
            e = m
        }
    }

    println(result)
}