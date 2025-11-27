import kotlin.math.abs

fun main() {
    val sb = StringBuilder()
    val n = readln().toInt()
    val list = mutableListOf(1L)
    val MAX = 1_000_000_000_000_000_000L

    while (list.last() < MAX) {
        list.add(list.last() * 2)
    }

    val size = list.size
    val arr = Array(size) { LongArray(size) }

    for (i in 0 until size) {
        for (j in 0 until size) {
            arr[i][j] = list[i] + list[j]
        }
    }

    repeat(n) {
        val m = readln().toLong()
        var diff = Long.MAX_VALUE
        var pos = 0 to 0


        for (i in 0 until size) {
            for (j in 0 until size) {
                if (abs(m - arr[i][j]) < diff) {
                    diff = abs(m - arr[i][j])
                    pos = i to j
                }
            }
        }

        sb.appendLine("${pos.first} ${pos.second}")
    }

    print(sb)
}