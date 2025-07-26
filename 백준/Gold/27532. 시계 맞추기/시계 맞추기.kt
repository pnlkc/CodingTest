fun main() {
    val M = readln().toInt()
    val arr = IntArray(M)
    var result = M
    val MOD = 720

    repeat(M) {
        val (h, m) = readln().split(":").map { it.toInt() }

        arr[it] = (h * 60 + m) % MOD
    }

    for (diff in 1..MOD) {
        val check = BooleanArray(MOD + 1)

        for (i in 0 until M) {
            var idx = arr[i] - i * diff

            while (idx < 0) {
                idx += MOD
            }

            check[idx] = true
        }

        result = minOf(result, check.count { it })
    }

    println(result)
}