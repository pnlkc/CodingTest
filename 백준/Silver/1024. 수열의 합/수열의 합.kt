fun main() {
    val (n, l) = readln().split(" ").map { it.toInt() }

    for (len in l..100) {
        val s = n / len - (len - 1) / 2

        if (s >= 0) {
            val sum = (s + s + len - 1) * len / 2

            if (sum == n) {
                println((s until s + len).joinToString(" "))
                return
            }
        }
    }

    println(-1)
}