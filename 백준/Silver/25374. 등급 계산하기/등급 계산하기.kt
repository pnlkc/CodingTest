fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val arr = IntArray(101)
    val rank = intArrayOf(4, 11, 23, 40, 60, 77, 89, 96, 100)
    val result = IntArray(9)
    var idx = 0
    var cnt = 0

    for (i in 0 until n) {
        arr[list[i]]++
    }

    for (i in 100 downTo 0) {
        if (arr[i] == 0) continue

        result[idx] += arr[i]
        cnt += arr[i]

        while (idx < 9 && rank[idx] <= cnt) {
            idx++
        }
    }

    println(result.joinToString("\n"))
}