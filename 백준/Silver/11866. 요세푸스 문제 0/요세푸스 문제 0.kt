import java.util.*

fun main() {
    val (size, n) = readln().split(" ").map { it.toInt() }
    val queue = LinkedList<Int>()
    val s = StringBuilder("<")

    queue.addAll(1..size)

    while (queue.isNotEmpty()) {
        repeat(n - 1) {
            queue.offer(queue.poll())
        }

        s.append(queue.poll()!!)
        if (queue.size > 0) s.append(", ")
    }

    s.append('>')

    println(s.toString())
}