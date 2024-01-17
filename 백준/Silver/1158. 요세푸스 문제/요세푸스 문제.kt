import java.util.LinkedList

fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    val q = LinkedList<Int>()
    val list = mutableListOf<Int>()

    for (i in 1.. N) {
        q.offer(i)
    }

    while (q.isNotEmpty()) {
        for (i in 1 until K) {
            q.offer(q.poll())
        }

        list.add(q.poll()!!)
    }

    println("<${list.joinToString(", ")}>")
}