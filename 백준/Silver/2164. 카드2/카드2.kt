import java.util.*

fun main() {
    val queue = LinkedList<Int>()
    queue.addAll(1..readln().toInt())

    while (queue.size > 1) {
        queue.poll()
        queue.offer(queue.poll())
    }

    println(queue.poll()!!)
}