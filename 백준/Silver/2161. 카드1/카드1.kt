import java.util.LinkedList

fun main() {
    val N = readln().toInt()
    val q = LinkedList<Int>()
    val result = mutableListOf<Int>()

    for (i in 1..N) {
        q.offer(i)
    }

    while (q.size > 1) {
        result.add(q.poll()!!)
        q.offer(q.poll())
    }

    result.add(q.poll()!!)

    println(result.joinToString(" "))
}