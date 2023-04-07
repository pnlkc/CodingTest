import java.util.*

fun main() {
    val result = intArrayOf(0, 0)
    val n = readln().toInt()
    val arr = Array(n) { readln().split(" ").map { it.toInt() } }
    val queue = LinkedList<IntArray>()

    queue.add(intArrayOf(0, n - 1, 0 , n - 1))

    while (queue.isNotEmpty()) {
        val c = queue.poll()!!
        val exist = booleanArrayOf(false, false)

        p@for (i in c[0]..c[1]) {
            for (j in c[2]..c[3]) {
                if (arr[i][j] == 0) exist[0] = true
                if (arr[i][j] == 1) exist[1] = true
                if (exist[0] && exist[1]) break@p
            }
        }

        when {
            exist[0] && exist[1] -> {
                val xR = arrayOf(intArrayOf(c[0], (c[0] + c[1]) / 2), intArrayOf((c[0] + c[1]) / 2 + 1, c[1]))
                val yR = arrayOf(intArrayOf(c[2], (c[2] + c[3]) / 2), intArrayOf((c[2] + c[3]) / 2 + 1, c[3]))

                for (i in 0..1) {
                    for(j in 0..1) {
                        queue.add(intArrayOf(xR[i][0], xR[i][1], yR[j][0], yR[j][1]))
                    }
                }
            }
            exist[0] -> result[0]++
            exist[1] -> result[1]++
        }
    }

    println(result.joinToString("\n"))
}