fun main() {
    val n = readln().toInt()
    val cArr = BooleanArray(100_000) { true }
    val preSum = IntArray(100_000)
    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE
    var maxName = ""
    var minName = ""

    for (i in 2 until 100_000) {
        if (!cArr[i]) continue

        var num = i * 2

        while (num < 100_000) {
            cArr[num] = false
            num += i
        }
    }

    for (i in 2 until 100_000) {
        preSum[i] = preSum[i - 1] + if (cArr[i]) 1 else 0
    }

    repeat(n) {
        val (name, num) = readln().split(" ")
        val x = num.dropLast(5).toInt()
        val y = num.drop(5).toInt()
        val cnt = preSum[maxOf(x, y)] - preSum[minOf(x, y) - 1]

        if (max < cnt) {
            max = cnt
            maxName = name
        }

        if (max == cnt) maxName = minOf(maxName, name)

        if (min > cnt) {
            min = cnt
            minName = name
        }

        if (min == cnt) minName = minOf(minName, name)
    }

    println("$maxName\n$minName")
}