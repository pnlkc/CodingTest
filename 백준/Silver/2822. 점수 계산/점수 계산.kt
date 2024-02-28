import java.util.PriorityQueue

fun main() {
    val pq = PriorityQueue(compareByDescending<Pair<Int, Int>> { it.first })
    var sum = 0
    val result = mutableListOf<Int>()


    for (i in 1..8) {
        pq.offer(readln().toInt() to i)
    }

    for (i in 1..5) {
        val (cf, cs) = pq.poll()!!
        sum += cf
        result.add(cs)
    }

    result.sort()

    println(sum)
    println(result.joinToString(" "))
}