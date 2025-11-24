import java.util.LinkedList

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val arr = IntArray(n)
    var result = 1
    var isPossible = false

    repeat(n) {
        arr[it] = readln().toInt()
    }

    val q = LinkedList<Int>()
    val isVisit = BooleanArray(n)

    q.add(0)
    isVisit[0] = true

    while (q.isNotEmpty()) {
        val c = q.poll()!!
        val next = arr[c]

        if (isVisit[next]) continue

        if (next == k) {
            isPossible = true
            break
        }

        q.add(next)
        isVisit[next] = true
        result++
    }

    println(if (isPossible) result else -1)
}