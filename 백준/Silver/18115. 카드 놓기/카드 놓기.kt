import java.util.LinkedList

fun main() {
    val sb = StringBuilder()
    val n = readln().toInt()
    val dq = LinkedList<Int>()
    val list = readln().split(" ").map { it.toInt() }

    for (i in n - 1 downTo 0) {
        when (list[i]) {
            1 -> dq.addFirst(dq.size + 1)
            2 -> {
                val temp = dq.pollFirst()!!

                dq.addFirst(dq.size + 2)
                dq.addFirst(temp)
            }
            3 -> dq.addLast(dq.size + 1)
        }
    }

    while (dq.isNotEmpty()) {
        sb.append(dq.pollFirst()!!)
        if (dq.isNotEmpty()) sb.append(" ")
    }

    println(sb)
}