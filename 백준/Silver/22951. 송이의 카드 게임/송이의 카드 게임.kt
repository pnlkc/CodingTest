import java.util.LinkedList

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val q = LinkedList<Pair<Int, Int>>()

    for (i in 1..n) {
        val list = readln().split(" ").map { it.toInt() }

        list.forEach { q.add(it to i) }
    }

    while (q.size > 1) {
        val (card, num) = q.poll()!!

        for (i in 1 until card) {
            q.add(q.poll()!!)
        }
    }

    val (card, num) = q.poll()!!

    println("$num $card")
}