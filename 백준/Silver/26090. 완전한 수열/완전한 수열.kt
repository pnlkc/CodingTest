fun main() {
    val n = readln().toInt()
    val list = listOf(0) + readln().split(" ").map { it.toInt() }
    val preSum = IntArray(n + 1)
    val size = n * 2000
    val pL = BooleanArray(size + 1) { true }
    var result = 0

    (0..1).forEach { pL[it] = false }

    for (i in 1..n) {
        preSum[i] = preSum[i - 1] + list[i]
    }

    for (i in 2..size) {
        if (!pL[i]) continue

        var num = i * 2

        while (num + i <= size) {
            pL[num] = false
            num += i
        }
    }

    for (i in n downTo 2) {
        if (!pL[i]) continue

        for (j in 1..n - i + 1) {
            if (pL[preSum[j + i - 1] - preSum[j - 1]]) result++
        }
    }

    println(result)
}