fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { readln().split(" ").map { it.toInt() } }
    val happy = Array(n + 1) { IntArray(k + 1) }

    for (i in 1..n) {
        for (j in 0..k) {
            happy[i][j] = maxOf(
                happy[i][j],
                happy[i - 1][j],
                if (j == 0) 0 else happy[i][j - 1]
            )

            if (j + arr[i - 1][0] <= k) {
                happy[i][j + arr[i - 1][0]] = maxOf(
                    happy[i][j + arr[i - 1][0]],
                    happy[i - 1][j + arr[i - 1][0]],
                    happy[i - 1][j] + arr[i - 1][1]
                )
            }
        }
    }

    println(happy[n][k])
}