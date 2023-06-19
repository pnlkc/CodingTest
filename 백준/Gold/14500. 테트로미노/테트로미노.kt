fun main() {
    var max = 0
    val (n, m) = readln().split(' ').map(String::toInt)
    val f = Array(n) { listOf<Int>() }

    repeat(n) {
        f[it] = readln().split(' ').map(String::toInt)
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            // 파란색 블럭
            if (j + 3 < m) max = maxOf(max, (j..j + 3).sumOf { f[i][it] })
            if (i + 3 < n) max = maxOf(max, (i..i + 3).sumOf { f[it][j] })

            // 노란색 블럭
            if (i + 1 < n && j + 1 < m) {
                max = maxOf(max, f[i][j] + f[i + 1][j] + f[i][j + 1] + f[i + 1][j + 1])
            }

            // 주황색 블럭
            if (i - 2 >= 0) {
                val sum = (i - 2..i).sumOf { f[it][j] }
                if (j + 1 < m) max = maxOf(max, sum + f[i - 2][j + 1])
                if (j - 1 >= 0) max = maxOf(max, sum + f[i - 2][j - 1])
            }

            if (i + 2 < n) {
                val sum = (i..i + 2).sumOf { f[it][j] }
                if (j + 1 < m) max = maxOf(max, sum + f[i + 2][j + 1])
                if (j - 1 >= 0) max = maxOf(max, sum + f[i + 2][j - 1])
            }

            if (j - 2 >= 0) {
                val sum = (j - 2..j).sumOf { f[i][it] }
                if (i + 1 < n) max = maxOf(max, sum + f[i + 1][j - 2])
                if (i - 1 >= 0) max = maxOf(max, sum + f[i - 1][j - 2])
            }

            if (j + 2 < m) {
                val sum = (j..j + 2).sumOf { f[i][it] }
                if (i + 1 < n) max = maxOf(max, sum + f[i + 1][j + 2])
                if (i - 1 >= 0) max = maxOf(max, sum + f[i - 1][j + 2])
            }

            // 녹색 블럭
            if (i + 2 < n) {
                if (j + 1 < m) {
                    max = maxOf(max, f[i][j] + f[i + 1][j] + f[i + 1][j + 1] + f[i + 2][j + 1])
                }

                if (j - 1 >= 0) {
                    max = maxOf(max, f[i][j] + f[i + 1][j] + f[i + 1][j - 1] + f[i + 2][j - 1])
                }
            }

            if (j + 2 < m) {
                if (i + 1 < n) {
                    max = maxOf(max, f[i][j] + f[i][j + 1] + f[i + 1][j + 1] + f[i + 1][j + 2])
                }

                if (i - 1 >= 0) {
                    max = maxOf(max, f[i][j] + f[i][j + 1] + f[i - 1][j + 1] + f[i - 1][j + 2])
                }
            }

            // 보라색 블럭
            if (i + 2 < n) {
                val sum = (i..i + 2).sumOf { f[it][j] }
                if (j + 1 < m) max = maxOf(max, sum + f[i + 1][j + 1])
                if (j - 1 >= 0) max = maxOf(max, sum + f[i + 1][j - 1])
            }
            
            if (j + 2 < m) {
                val sum = (j..j + 2).sumOf { f[i][it] }
                if (i + 1 < n) max = maxOf(max, sum + f[i + 1][j + 1])
                if (i - 1 >= 0) max = maxOf(max, sum + f[i - 1][j + 1])
            }
        }
    }

    println(max)
}