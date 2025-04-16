fun main() {
    val (N, K, A) = readln().split(" ").map { it.toInt() }
    var min = Int.MAX_VALUE

    for (i in 1..N) {
        val (t, s) = readln().split(" ").map { it.toInt() }
        val dt = K / A / t
        val mt = K / A % t
        val result = dt * t + mt + (dt - 1 + if (mt != 0) 1 else 0) * s

        min = minOf(min, result)
    }

    println(min)
}
