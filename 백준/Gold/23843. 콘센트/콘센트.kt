import java.util.PriorityQueue

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toLong() }.sortedDescending()
    val pq = PriorityQueue<Long>()
    var result = 0L

    for (i in 0 until n) {
        pq.add(if (pq.size < m) list[i] else pq.poll()!! + list[i])
    }

    while (pq.isNotEmpty()) {
        result = pq.poll()!!
    }

    println(result)
}