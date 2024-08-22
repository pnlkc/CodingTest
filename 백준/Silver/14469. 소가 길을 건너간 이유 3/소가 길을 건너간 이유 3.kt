import java.util.PriorityQueue

data class Data(val arrivalTime: Int, val time: Int)

fun main() {
    val N = readln().toInt()
    val pq = PriorityQueue<Data> { a, b -> a.arrivalTime - b.arrivalTime }
    var time = 0

    for (i in 1..N) {
        val (a, b) = readln().split(" ").map { it.toInt() }

        pq.offer(Data(a, b))
    }

    while (pq.isNotEmpty()) {
        val (at, t) = pq.poll()!!

        time = if (at > time) at + t else time + t
    }

    println(time)
}
