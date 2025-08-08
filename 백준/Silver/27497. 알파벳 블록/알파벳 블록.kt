import java.util.LinkedList

fun main() {
    val N = readln().toInt()
    val dq = LinkedList<Char>()
    val log = LinkedList<Boolean>()

    repeat(N) {
        val input = readln()

        when (input[0]) {
            '1' -> {
                val (_, c) = input.split(" ")

                dq.addLast(c[0])
                log.add(false)
            }
            '2' -> {
                val (_, c) = input.split(" ")

                dq.addFirst(c[0])
                log.add(true)
            }
            '3' -> {
                if (log.isNotEmpty()) {
                    if (log.pollLast()!!) dq.pollFirst() else dq.pollLast()
                }
            }
        }
    }

    println(if (dq.isEmpty()) 0 else dq.joinToString(""))
}