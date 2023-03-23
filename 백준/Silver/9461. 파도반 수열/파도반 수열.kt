fun main() {
    val memo = mutableListOf(1L, 1L, 1L, 2L, 2L)
    for (testcase in 1..readln().toInt()) {
        val n = readln().toInt()
        if (memo.size < n) {
            for (i in memo.lastIndex until n) {
                memo.add(memo[i] + memo[i - 4])
            }
        }
        println(memo[n - 1])
    }
}