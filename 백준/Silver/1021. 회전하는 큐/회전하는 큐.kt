import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val target = readln().split(" ").map { it.toInt() }
    var r = 0
    val queue = LinkedList<Int>()
    queue.addAll(1..n)

    for (i in target.indices) {
        val t = target[i]
        var count = 0

        while (queue.peek() != t) {
            queue.offer(queue.poll())
            count++
        }

        r += minOf(count, queue.size - count)
        queue.poll()
    }

    println(r)
}