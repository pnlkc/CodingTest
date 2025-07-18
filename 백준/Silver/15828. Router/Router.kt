import java.util.LinkedList

fun main() {
    val sb = StringBuilder()
    val N = readln().toInt()
    val q = LinkedList<Int>()

    while (true) {
        val num = readln().toInt()

        when (num) {
            -1 -> break
            0 -> q.poll()!!
            else -> if (q.size < N) q.add(num)
        }
    }

    while (q.isNotEmpty()) {
        sb.append(q.poll()!!)
        if (q.isNotEmpty()) sb.append(" ")
    }
    
    println(sb.ifEmpty { "empty" })
 }