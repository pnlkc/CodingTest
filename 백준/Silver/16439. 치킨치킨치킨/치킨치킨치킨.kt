fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { readln().split(" ").map { it.toInt() } }
    var max = 0

    for (i in 0..m - 3) {
        for (j in i + 1..m - 2) {
            for (k in j + 1..m - 1) {
                var result = 0

                for (l in 0 until n) {
                    result += maxOf(arr[l][i], arr[l][j], arr[l][k])
                }

                max = maxOf(max, result)
            }
        }
    }

    println(max)
}