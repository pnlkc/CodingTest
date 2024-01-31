import java.util.PriorityQueue

data class Data(val name: String, val a: Int, val b: Int, val c: Int)

fun main() {
    val N = readln().toInt()
    val list = mutableListOf<Data>()
    val sb = StringBuilder()
    val pq = PriorityQueue(
        compareByDescending<Data> { it.a }
            .thenBy { it.b }
            .thenByDescending { it.c }
            .thenBy { it.name }
    )

    for (i in 1..N) {
        val (name, a, b, c) = readln().split(" ")

        pq.offer(Data(name, a.toInt(), b.toInt(), c.toInt()))
    }
    
    while (pq.isNotEmpty()) {
        sb.append("${pq.poll()!!.name}\n")
    }

    println(sb)
}