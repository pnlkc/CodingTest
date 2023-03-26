fun main() {
    val num = readln().toInt()
    val memo = IntArray(num + 1) { Int.MAX_VALUE }
    memo[num] = 0
    for (i in num downTo 2) {
        memo[i - 1] = minOf(memo[i] + 1, memo[i - 1])
        if (i % 3 == 0) memo[i / 3] = minOf(memo[i] + 1, memo[i / 3])
        if (i % 2 == 0) memo[i / 2] = minOf(memo[i] + 1, memo[i / 2])
    }
    println(memo[1])
}