import java.util.*

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    if (n == k) return println(0)
    
    val map = mutableMapOf<Int, Int>()
    val queue = LinkedList<Int>()
    
    queue.add(n)
    map[n] = 0
    
    val logic: (Int, Int) -> Unit = { num, time ->
        if (map[num] == null || map[num]!! > time) {
            map[num] = time
            queue.add(num)
        }
    }

    while(queue.isNotEmpty()) {
        val c = queue.poll()!!
        val time = map[c]!! + 1
        
        if (c < k) {
            logic(c * 2, time)
            logic(c + 1, time)
        }
        if (c > 0) logic(c - 1, time)
        if (c * 2 == k || c + 1 == k || c - 1 == k) return println(time)
    }
}