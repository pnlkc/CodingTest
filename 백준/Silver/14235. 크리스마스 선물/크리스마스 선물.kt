import java.util.PriorityQueue

fun main() {
    val sb = StringBuilder()
    val n = readln().toInt()
    val pq = PriorityQueue<Int>(reverseOrder())

    for (i in 0 until n) {
        val input = readln().split(" ")

        if (input[0] == "0") {
            sb.appendLine(if (pq.isNotEmpty()) pq.poll()!! else -1)
        } else {
            for (j in 1..input[0].toInt()) {
                pq.add(input[j].toInt())
            }
        }
    }

    print(sb)
}