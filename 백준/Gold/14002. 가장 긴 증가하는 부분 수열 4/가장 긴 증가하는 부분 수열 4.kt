fun main() {
    val a = readln().toInt()
    val arr = readln().split(' ').map(String::toInt)
    val dp = arr.map { mutableListOf(it) }.toTypedArray()
    var max = mutableListOf(arr[0])

    for (i in 1 until a) {
        for (j in 0 until i) {
            if (arr[i] > arr[j] && dp[i].size < dp[j].size + 1) {
                dp[i] = dp[j].toMutableList()
                dp[i].add(arr[i])
            }
        }

        if (max.size < dp[i].size) max = dp[i]
    }

    println(max.size)
    println(max.joinToString(" "))
}