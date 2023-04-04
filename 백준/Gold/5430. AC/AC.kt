import java.util.*

fun main() {
    val s = StringBuilder()

    repeat(readln().toInt()) {
        var isError = false
        var isMirror = false
        val command = readln()
        val queue = LinkedList<String>()
        readln()
        val input = readln()
        val list = input.substring(1, input.lastIndex)

        if (list.isNotBlank()) queue.addAll(list.split(","))

        for (c in command) {
            when (c) {
                'R' -> isMirror = !isMirror
                else -> {
                    if (queue.isEmpty()) {
                        isError = true
                        break
                    } else {
                        if (isMirror) queue.pollLast() else queue.poll()
                    }
                }
            }
        }

        if (isError) s.appendLine("error")
        else if (isMirror) s.appendLine("[" + queue.reversed().joinToString(",") + "]")
        else s.appendLine("[" + queue.joinToString(",") + "]")
    }

    println(s.toString())
}