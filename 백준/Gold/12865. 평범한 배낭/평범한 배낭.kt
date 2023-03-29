fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { readln().split(" ").map { it.toInt() } }
    val happy = Array(n + 1) { IntArray(k + 1) }

    for (i in 1..n) {
        for (j in 0..k) {
            happy[i][j] = maxOf(
                happy[i - 1][j],
                if (j > 0) happy[i][j - 1] else 0,
                if (j >= arr[i - 1][0]) happy[i - 1][j - arr[i - 1][0]] + arr[i - 1][1] else 0
            )
        }
    }

    println(happy[n][k])
}