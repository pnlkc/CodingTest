fun main() {
    val num = readln().toInt()
    val arr = Array(num) { IntArray(10) { 1 } }
    arr[0][0] = 0

    for (i in 1 until num) {
        for (j in 0..9) {
            val f = if (j - 1 in 0..8) arr[i - 1][j - 1] else 0
            val e = if (j + 1 in 1..9) arr[i - 1][j + 1] else 0
            arr[i][j] = (f + e) % 1_000_000_000
        }
    }

    println(arr[num - 1].sumOf { it.toLong() } % 1_000_000_000)
}