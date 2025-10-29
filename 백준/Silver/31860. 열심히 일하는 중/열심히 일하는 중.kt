import java.util.PriorityQueue

fun main() {
    val sb = StringBuilder()
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    val pq = PriorityQueue<Int>(reverseOrder())
    var cnt = 0
    var prev = 0

    repeat(n) {
        pq.add(readln().toInt())
    }

    while (pq.isNotEmpty()) {
        val c = pq.poll()!!

        if (c <= k) continue

        prev = c + if (prev == 0) 0 else prev / 2
        pq.add(c - m)
        sb.appendLine(prev)
        cnt++
    }

    println(cnt)
    print(sb)
}