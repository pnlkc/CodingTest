import java.util.Comparator
import java.util.PriorityQueue

fun main() {
    val sb = StringBuilder()
    val N = readln().toInt()
    val pq = PriorityQueue<Int>(Comparator.reverseOrder())

    for (i in 1..N) {
        val num = readln().toInt()

        pq.offer(num)
    }

    while (pq.isNotEmpty()) {
        val num = pq.poll()!!

        sb.appendLine(num)
    }

    print(sb)
}