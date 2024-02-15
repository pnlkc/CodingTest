import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val A = StringTokenizer(readln())
    val B = StringTokenizer(readln())
    val pq = PriorityQueue<Int>()
    val sb = StringBuilder()

    for (i in 1..N) {
        pq.add(A.nextToken().toInt())
    }

    for (i in 1..M) {
        pq.add(B.nextToken().toInt())
    }

    while (pq.isNotEmpty()) {
        sb.append(pq.poll()!!)

        if (pq.isNotEmpty()) {
            sb.append(" ")
        }
    }

    println(sb)
}
