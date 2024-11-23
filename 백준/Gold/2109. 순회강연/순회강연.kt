import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val arr = Array(n) { 0 to 0 }
    val pq = PriorityQueue<Int>()

    for (i in 0 until n) {
        val (d, p) = readln().split(" ").map { it.toInt() }
        arr[i] = d to p
    }

    arr.sortWith(compareBy<Pair<Int, Int>> { it.second }.thenByDescending { it.first })

    var idx = 0

    while (idx < n) {
        if (arr[idx].second == pq.size) {
            if (pq.isNotEmpty() && pq.peek()!! < arr[idx].first) {
                pq.poll()!!
                pq.offer(arr[idx].first)
            }
        } else if (arr[idx].second > pq.size) {
            pq.offer(arr[idx].first)
        }

        idx++
    }

    var sum = 0
    while (pq.isNotEmpty()) {
        sum += pq.poll()!!
    }

    println(sum)
}
