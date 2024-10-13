import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = mutableMapOf<Int, MutableList<Int>>()
    val st = StringTokenizer(readln())
    val dp = IntArray(n + 1)

    for (i in 1..n) {
        val num = st.nextToken().toInt()
        if (map[num] == null) map[num] = mutableListOf()
        map[num]!!.add(i)
    }

    for (tc in 0 until m) {
        val (i, w) = readln().split(" ").map { it.toInt() }
        dp[i] += w
    }

    val q = LinkedList<Int>()
    q.offer(1)

    while (q.isNotEmpty()) {
        val num = q.poll()!!

        if (map[num] == null) continue

        for (next in map[num]!!) {
            dp[next] += dp[num]
            q.offer(next)
        }
    }

    println(dp.drop(1).joinToString(" "))
}