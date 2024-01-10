import java.util.LinkedList

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val cnt = IntArray(n + 1)
    val result = IntArray(n)
    
    for (i in 1..m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        cnt[b]++
    }
    
    val q = LinkedList<Int>()
    var r = 0
    
    for (i in 1..n) {
        if (cnt[i] == 0) q.offer(i)
    }
    
    while (q.isNotEmpty()) {
        r++
        val num = q.size
        
        for (i in 1..num) {
            val c = q.poll()
            
            result[c - 1] = r
            
            for (j in graph[c]) {
                if (--cnt[j] == 0) {
                    q.offer(j)
                }
            }
        }
    }
    
    println(result.joinToString(" "))
}