import java.lang.StringBuilder
import java.util.PriorityQueue

fun main() {
    val sb = StringBuilder()
    val N = readln().toInt()
    val pq = PriorityQueue(
        compareBy<String> { it.length }
            .thenBy { str ->
                str.filter { it.isDigit() }.map { it.digitToInt() }.sum()
            }
            .thenBy { it }
    )

    for (i in 1..N) {
        pq.add(readln())
    }

    while (pq.isNotEmpty()) {
        sb.appendLine(pq.poll()!!)
    }

    print(sb)
}