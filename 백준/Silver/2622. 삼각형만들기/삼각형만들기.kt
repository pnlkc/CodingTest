fun main() {
    val n = readln().toInt()
    var cnt = 0

    for (i in 1..n / 3) {
        for (j in i..n / 2) {
            val k = n - i - j

            if (j <= k && i + j > k) cnt++
        }
    }

    println(cnt)
}