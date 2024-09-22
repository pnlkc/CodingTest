import java.util.PriorityQueue

fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()
    val pq = PriorityQueue<Long>()

    for (tc in 1..T) {
        val K = readln().toInt()
        val list = readln().split(" ").map { it.toLong() }
        var sum = 0L

        pq.clear()
        pq.addAll(list)

        while (pq.size > 1) {
            val a = pq.poll()!!
            val b = pq.poll()!!

            sum += a + b
            pq.add(a + b)
        }

        sb.appendLine(sum)
    }

    print(sb)
}