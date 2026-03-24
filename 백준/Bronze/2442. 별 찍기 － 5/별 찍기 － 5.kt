fun main() {
    val n = readln().toInt()
    val arr = Array(n) { CharArray(2 * n - 1) { '*' } }

    for (i in 0 until n) {
        for (j in 0 until i) {
            arr[n - 1 - i][j] = ' '
            arr[n - 1 - i][2 * (n - 1) - j] = ' '
        }
    }

    arr.forEach { println(it.joinToString("").trimEnd()) }
}