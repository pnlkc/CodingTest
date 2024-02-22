import java.lang.StringBuilder
import java.util.LinkedList

fun main() {
    val tc = readln().toInt()
    val sb = StringBuilder()

    (1..tc).forEach { _ ->
        val input = readln()
        val front = LinkedList<Char>()
        val back = LinkedList<Char>()
        val result = StringBuilder()

        for (c in input) {
            when (c) {
                '<' -> {
                    if (front.isNotEmpty()) {
                        back.addFirst(front.pollLast())
                    }
                }
                '>' -> {
                    if (back.isNotEmpty()) {
                        front.addLast(back.pollFirst())
                    }
                }
                '-' -> {
                    if (front.isNotEmpty()) {
                        front.pollLast()
                    }
                }
                else -> front.addLast(c)
            }
        }

        while (front.isNotEmpty()) {
            result.append(front.pollFirst()!!)
        }

        while (back.isNotEmpty()) {
            result.append(back.pollFirst()!!)
        }

        sb.appendLine(result.toString())
    }

    print(sb)
}