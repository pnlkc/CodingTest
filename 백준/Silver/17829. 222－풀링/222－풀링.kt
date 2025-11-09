fun main() {
    var n = readln().toInt()
    var arr = Array(n) { IntArray(n) }

    for (i in 0 until n) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until n) {
            arr[i][j] = input[j]
        }
    }

    while (n > 1) {
        val temp = Array(n / 2) { IntArray(n / 2) }

        for (i in 0 until n step 2) {
            for (j in 0 until n step 2) {
                val list = listOf(arr[i][j], arr[i][j + 1], arr[i + 1][j], arr[i + 1][j + 1])

                temp[i / 2][j / 2] = list.sorted()[2]
            }
        }

        n /= 2
        arr = temp
    }

    println(arr[0][0])
}