import java.util.PriorityQueue

fun main() {
    val N = readln().toInt()
    var dasom = readln().toInt()
    val pq = PriorityQueue<Int>(Comparator.reverseOrder())
    var cnt = 0

    for (i in 2..N) {
        val num = readln().toInt()
        pq.offer(num)
    }

    while (pq.isNotEmpty() && pq.peek()!! >= dasom) {
        val c = pq.poll()!!
        dasom++
        pq.add(c - 1)
        cnt++
    }

    println(cnt)
}