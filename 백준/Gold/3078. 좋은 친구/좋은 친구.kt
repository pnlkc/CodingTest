import java.util.LinkedList

fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    val len = IntArray(21)
    val q = LinkedList<String>()
    var result = 0L

    for (i in 1..N) {
        val name = readln()
        val nameLen = name.length

        if (q.size > K) len[q.poll()!!.length]--
        result += len[nameLen]
        q.offer(name)
        len[nameLen]++
    }

    println(result)
}