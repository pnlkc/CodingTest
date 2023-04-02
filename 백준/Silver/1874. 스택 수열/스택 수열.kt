import java.util.*

fun main() {
    val n = readln().toInt()
    val stack = Stack<Int>()
    val queue = LinkedList<Int>()
    val answer = StringBuilder()
    val logic: () -> Unit = {
        while (true) {
            if (stack.isEmpty() || queue.isEmpty()) break

            if (stack.peek()!! == queue.peek()!!) {
                stack.pop()
                queue.poll()
                answer.append('-').append("\n")
            } else {
                break
            }
        }
    }

    repeat(n) {
        queue.add(readln().toInt())
    }

    for (i in 1..n) {
        logic()
        answer.append('+').append("\n")
        stack.add(i)
    }

    logic()

    println(if (stack.isEmpty()) answer.toString() else "NO")
}