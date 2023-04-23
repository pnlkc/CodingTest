import java.util.LinkedList

fun main() {
    val sb = StringBuilder()
    val queue = LinkedList<Int>()
    repeat(readln().toInt()) {
        when (val input = readln()) {
            "pop" -> sb.appendLine(queue.poll() ?: -1)
            "size" -> sb.appendLine(queue.size)
            "empty" -> sb.appendLine(if (queue.isEmpty()) 1 else 0)
            "front" -> sb.appendLine(queue.peekFirst() ?: -1)
            "back" -> sb.appendLine(queue.peekLast() ?: -1)
            else -> queue.add(input.split(" ")[1].toInt())
        }
    }
    println(sb.toString())
}