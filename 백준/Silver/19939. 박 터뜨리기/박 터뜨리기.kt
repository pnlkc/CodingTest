fun main() {
    var (N, K) = readln().split(" ").map { it.toInt() }
    val arr = IntArray(N) { it + 1 }

    N -= (K + 1) * K / 2

    if (N < 0) {
        println(-1)
        return
    }

    while (N > 0) {
        for (i in K - 1 downTo 0) {
            arr[i]++
            if (--N == 0) break
        }
    }

    println(arr[K - 1] - arr[0])
}