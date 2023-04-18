fun main() {
    val n1 = readln().toInt()
    val arr1 = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    val n2 = readln().toInt()
    val arr2 = readln().split(" ").map { it.toInt() }.toIntArray()
    val dp = Array(n1 + 1) { BooleanArray(30_001) }
    val answer = mutableListOf<String>()

    for (i in 0 until n1) {
        for (j in 0..30_000) {
            if (dp[i][j]) {
                dp[i + 1][j] = true
                if (j + arr1[i] in 0..30_000) dp[i + 1][j + arr1[i]] = true
                if (j - arr1[i] in 0..30_000) dp[i + 1][j - arr1[i]] = true
            }
        }

        dp[i + 1][15_000 + arr1[i]] = true
        dp[i + 1][15_000 - arr1[i]] = true
    }

    arr2.forEach { answer.add(if (it > 15_000) "N" else if (dp.last()[15_000 + it]) "Y" else "N") }

    println(answer.joinToString(" "))
}