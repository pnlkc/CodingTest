fun main() {
    val (N, K) = splitToInt()
    var sL = splitToInt().toIntArray()
    val dL = splitToInt()
    val arr = IntArray(N)

    for (i in 1..K) {
        for (j in 0 until N) {
            arr[dL[j] - 1] = sL[j]
        }

        sL = arr.clone()
    }

    println(sL.joinToString(" "))
}

fun splitToInt() = readln().split(" ").map { it.toInt() }