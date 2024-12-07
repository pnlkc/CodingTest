import java.util.LinkedList

data class Data(val num: Long, val str: String)

fun main() {
    val (s, t) = readln().split(" ").map { it.toInt() }

    if (s == t) {
        println(0)
        return
    }

    val q = LinkedList<Data>()
    val isVisit = mutableMapOf<Long, Boolean>()
    val result = mutableListOf<String>()

    q.offer(Data(s.toLong(), ""))
    isVisit[s.toLong()] = true

    while (q.isNotEmpty()) {
        val (cn, cs) = q.poll()!!

        if (cn == t.toLong()) {
            result.add(cs)
            println(cs)
            return
        }

        if (cn * cn <= t && isVisit[cn * cn] == null) {
            q.offer(Data(cn * cn , "$cs*"))
            isVisit[cn * cn] = true
        }

        if (cn + cn <= t && isVisit[cn + cn] == null) {
            q.offer(Data(cn + cn , "$cs+"))
            isVisit[cn + cn] = true
        }

        if (isVisit[1] == null) {
            q.offer(Data(1L, "$cs/"))
            isVisit[1] = true
        }
    }

    println(-1)
}