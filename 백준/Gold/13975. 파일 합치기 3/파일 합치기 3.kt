import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()
    val pq = PriorityQueue<Long>()

    for (tc in 1..readln().toInt()) {
        val K = readln().toInt()
        val st = StringTokenizer(readln())
        var sum = 0L

        pq.clear()
        repeat(K) {
            pq.add(st.nextToken().toLong())
        }

        while (pq.size > 1) {
            val plus = pq.poll()!! + pq.poll()!!
            
            sum += plus
            pq.add(plus)
        }

        sb.appendLine(sum)
    }

    print(sb)
}