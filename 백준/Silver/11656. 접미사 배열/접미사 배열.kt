import java.util.PriorityQueue

fun main() {
    var S = readln()
    val pq = PriorityQueue<String>()
    val sb = StringBuilder()

    while (S.isNotEmpty()) {
        pq.offer(S)
        S = S.drop(1)
    }

    while (pq.isNotEmpty()) {
        sb.appendLine(pq.poll())
    }

    print(sb)
}