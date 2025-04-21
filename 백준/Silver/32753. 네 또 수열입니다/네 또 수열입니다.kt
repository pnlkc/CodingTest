fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    val NK = N * K

    println(
        if (NK - 1 > K) {
            -1
        } else {
            val arr = IntArray(NK) { 1 }
            var idx = 0

            for (i in 1..N) {
                for (j in 0 until K) {
                    arr[idx++] = i
                }
            }

            arr.joinToString(" ")
        }
    )
}