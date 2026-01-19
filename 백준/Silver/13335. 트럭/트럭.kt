import java.util.LinkedList

fun main() {
    val (n, w, l) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    val q = LinkedList<Int>()
    var sum = 0
    var result = 0
    var idx = 0

    repeat(w) {
        q.add(0)
    }

    while (idx < n) {
        sum -= q.pollFirst()!!

        if (sum + list[idx] > l) {
            q.add(0)
        } else {
            q.add(list[idx])
            sum += list[idx++]
        }

        result++
    }

    while (q.isNotEmpty()) {
        q.pollFirst()
        result++
    }

    println(result)
}