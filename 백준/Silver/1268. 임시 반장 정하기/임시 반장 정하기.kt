fun main() {
    val n = readln().toInt()
    val arr = Array(n) { IntArray(5) }
    val cnt = Array(n) { BooleanArray(n) }

    for (i in 0 until n) {
        val input = readln().split(" ").map { it.toInt() }.toIntArray()

        arr[i] = input
    }

    for (i in 0..4) {
        for (j in 0 until n) {
            for (k in 0 until n) {
                if (arr[j][i] == arr[k][i]) cnt[j][k] = true
            }
        }
    }

    println(cnt.mapIndexed { index, booleans -> index + 1 to booleans.count { it } }.sortedByDescending { it.second }[0].first)
}