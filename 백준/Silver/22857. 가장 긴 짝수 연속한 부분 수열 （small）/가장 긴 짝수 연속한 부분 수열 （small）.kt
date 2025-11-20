fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    val preSum = IntArray(n + 1)
    var result = 0

    for (i in 0 until n) {
        preSum[i + 1] = preSum[i] + if(list[i] % 2 == 1) 1 else 0
    }

    for (i in 0 until n) {
        var s = i
        var e = n - 1
        var max = 0

        while (s <= e) {
            val m = (s + e) / 2
            val cnt = preSum[m + 1] - preSum[i]

            if (cnt > k) {
                e = m - 1
            } else {
                s = m + 1
                max = maxOf(max, m + 1 - i - cnt)
            }
        }

        result = maxOf(result, max)
    }

    println(result)
}