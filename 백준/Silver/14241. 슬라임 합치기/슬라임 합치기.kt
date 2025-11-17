import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val pq = PriorityQueue<Int>(reverseOrder())
    val st = StringTokenizer(readln())
    var result = 0

    while (st.hasMoreTokens()) {
        pq.add(st.nextToken().toInt())
    }

    while (pq.size > 1) {
        val a = pq.poll()!!
        val b = pq.poll()!!

        result += a * b
        pq.add(a + b)
    }

    println(result)
}