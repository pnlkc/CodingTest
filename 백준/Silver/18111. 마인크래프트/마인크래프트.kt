fun main() {
    val (n, m, b) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val avg = (arr.sumOf { it.average() } / n).toInt()
    val l = intArrayOf(avg, Int.MAX_VALUE)
    val r = intArrayOf(avg, Int.MAX_VALUE)

    while (true) {
        val result = intArrayOf(0, 0)

        for (j in 0 until n) {
            for (k in 0 until m) {
                if (arr[j][k] < l[0]) {
                    result[0] += l[0] - arr[j][k]
                    result[1] += l[0] - arr[j][k]
                } else if (arr[j][k] > l[0]) {
                    result[0] += (arr[j][k] - l[0]) * 2
                    result[1] -= arr[j][k] - l[0]
                }
            }
        }

        if (result[1] > b) l[0]--
        else if (result[0] < l[1]) l[1] = result[0]
        else break
    }

    while (true) {
        val result = intArrayOf(0, 0)

        for (j in 0 until n) {
            for (k in 0 until m) {
                if (arr[j][k] < r[0]) {
                    result[0] += r[0] - arr[j][k]
                    result[1] += r[0] - arr[j][k]
                } else if (arr[j][k] > r[0]) {
                    result[0] += (arr[j][k] - r[0]) * 2
                    result[1] -= arr[j][k] - r[0]
                }
            }
        }

        if (result[1] > b) break
        else if (result[0] <= r[1]) {
            r[1] = result[0]
            r[0]++
        }
        else break
    }

    l[0]--
    r[0]--

    println(if (r[1] > l[1]) "${l[1]} ${l[0]}" else "${r[1]} ${r[0]}")
}