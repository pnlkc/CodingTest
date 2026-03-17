import java.util.LinkedList

fun main() {
    val sb = StringBuilder()
    val t = readln().toInt()

    for (tc in 1..t) {
        val n = readln().toInt()
        val list = readln().split(" ")
        val dq = LinkedList<Char>()

        for (i in 0 until n) {
            val c = list[i][0]

            when {
                dq.isEmpty() -> dq.add(c)
                dq.peekFirst()!! >= c -> dq.addFirst(c)
                else -> dq.addLast(c)
            }
        }

        while (dq.isNotEmpty()) {
            sb.append(dq.pollFirst()!!)
        }

        sb.appendLine()
    }

    print(sb)
}