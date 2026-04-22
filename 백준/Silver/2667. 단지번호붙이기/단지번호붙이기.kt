import java.util.*

fun main() {
    val n = readln().toInt()
    val arr = Array(n) { readln() }
    val queue = LinkedList<IntArray>()
    val r = mutableListOf<Int>()

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (arr[i][j] == '1') queue.add(intArrayOf(i, j))
        }
    }

    while (queue.isNotEmpty()) {
        var count = 0
        val c = queue.poll()!!
        val newQueue = LinkedList<IntArray>()

        newQueue.add(c)

        while (newQueue.isNotEmpty()) {
            val newC = newQueue.poll()!!
            count++

            for (i in 1..queue.size) {
                val nc = queue.poll()!!
                var result = false

                if (newC[0] == nc[0] && nc[1] in newC[1] - 1..newC[1] + 1) result = true
                else if (newC[1] == nc[1] && nc[0] in newC[0] - 1..newC[0] + 1) result = true

                if (result) newQueue.add(nc) else queue.add(nc)
            }
        }

        r.add(count)
    }

    println(r.size)
    println(r.sorted().joinToString("\n"))
}