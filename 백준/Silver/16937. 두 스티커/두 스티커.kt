fun main() {
    val (h, w) = readln().split(" ").map { it.toInt() }
    val n = readln().toInt()
    val arr = Array(n) { IntArray(2)  }
    var result = 0

    for (i in 0 until n) {
        val (r, c) = readln().split(" ").map { it.toInt() }

        arr[i][0] = r
        arr[i][1] = c
    }

    for (i in 0 until n - 1) {
        for (j in i + 1 until n) {
            val sum = arr[i][0] * arr[i][1] + arr[j][0] * arr[j][1]
            var isPossible = false

            if (arr[i][0] + arr[j][0] <= h && arr[i][1] <= w && arr[j][1] <= w) isPossible = true
            if (arr[i][1] + arr[j][1] <= h && arr[i][0] <= w && arr[j][0] <= w) isPossible = true
            if (arr[i][0] + arr[j][1] <= h && arr[i][1] <= w && arr[j][0] <= w) isPossible = true
            if (arr[i][1] + arr[j][0] <= h && arr[i][0] <= w && arr[j][1] <= w) isPossible = true
            if (arr[i][0] + arr[j][0] <= w && arr[i][1] <= h && arr[j][1] <= h) isPossible = true
            if (arr[i][1] + arr[j][1] <= w && arr[i][0] <= h && arr[j][0] <= h) isPossible = true
            if (arr[i][0] + arr[j][1] <= w && arr[i][1] <= h && arr[j][0] <= h) isPossible = true
            if (arr[i][1] + arr[j][0] <= w && arr[i][0] <= h && arr[j][1] <= h) isPossible = true
            if (isPossible) result = maxOf(result, sum)
        }
    }

    println(result)
}