import java.util.*

fun main() {
    val n = readln().toInt()
    val queue = LinkedList<Int>()
    val s = StringBuilder()

    repeat(n) {
        val input = StringTokenizer(readln())

        when (input.nextToken()) {
            "push" -> queue.add(input.nextToken().toInt())
            "pop" -> s.append(if (queue.isNotEmpty()) queue.poll() else -1).append("\n")
            "size" -> s.append(queue.size).append("\n")
            "empty" -> s.append(if (queue.isEmpty()) 1 else 0).append("\n")
            "front" -> s.append(if (queue.isNotEmpty()) queue.peek() else -1).append("\n")
            "back" -> s.append(if (queue.isNotEmpty()) queue.last else -1).append("\n")
        }
    }

    println(s.toString())
}