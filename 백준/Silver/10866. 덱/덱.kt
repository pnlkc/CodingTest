import java.util.*

fun main() {
    val deque = LinkedList<Int>()
    val s = StringBuilder()

    repeat(readln().toInt()) {
        val input = StringTokenizer(readln())
        when (input.nextToken()) {
            "push_front" -> deque.offerFirst(input.nextToken().toInt())
            "push_back" -> deque.offerLast(input.nextToken().toInt())
            "pop_front" -> s.appendLine(deque.pollFirst() ?: -1)
            "pop_back" -> s.appendLine(deque.pollLast() ?: -1)
            "size" -> s.appendLine(deque.size)
            "empty" -> s.appendLine(if (deque.isEmpty()) 1 else 0)
            "front" -> s.appendLine(deque.peekFirst() ?: -1)
            "back" -> s.appendLine(deque.peekLast() ?: -1)
        }
    }

    println(s.toString())
}