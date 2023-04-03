import java.util.*

fun main() {
    val n = StringTokenizer(readln()).nextToken().toInt()
    val target = StringTokenizer(readln())
    val queue = LinkedList((1..n).toList())
    var r = 0


    while (target.hasMoreTokens()) {
        val t = target.nextToken().toInt()
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