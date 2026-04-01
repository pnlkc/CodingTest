import java.util.LinkedList

fun main() {
    val n = readln().toInt()
    val q1 = LinkedList<String>()
    val q2 = LinkedList<String>()
    val map = mutableMapOf<String, Boolean>()
    var cnt = 0

    for (i in 0 until n) {
        q1.add(readln())
    }

    for (i in 0 until n) {
        q2.add(readln())
    }

    while (q1.isNotEmpty()) {
        if (q1.peekLast() == q2.peekLast()) {
            q1.pollLast()
            q2.pollLast()
        } else if (map[q2.peekLast()!!] != null) {
            q2.pollLast()
        } else {
            map[q1.pollLast()!!] = true
            cnt++
        }
    }

    println(cnt)
}