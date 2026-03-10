import java.util.LinkedList

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val q = LinkedList<Int>()
    var result = 0

    repeat(n) {
        val (l, s) = readln().split(" ").map { it.toInt() }

        for (i in 0 until l) {
            q.add(s)
        }
    }

    repeat(m) {
        val (l, s) = readln().split(" ").map { it.toInt() }

        for (i in 0 until l) {
            result = maxOf(result, s - q.pollFirst()!!)
        }
    }

    println(result)
}