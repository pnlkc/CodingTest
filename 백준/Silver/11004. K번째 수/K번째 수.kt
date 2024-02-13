import java.util.*

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val st = StringTokenizer(readln())
    val pq = PriorityQueue<Int>()
    
    for (i in 0 until n) {
        pq.add(st.nextToken().toInt())
    }
    
    for (i in 1 until k) {
        pq.poll()
    }
    
    println(pq.poll())
}