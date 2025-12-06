import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val target = m * 9 / 10 + if (m * 9 % 10 != 0) 1 else 0
    val q = LinkedList<Int>()
    val st = StringTokenizer(readln())
    val map = mutableMapOf<Int, Int>()

    while (q.size < m) {
        val num = st.nextToken().toInt()

        q.add(num)
        map[num] = map.getOrDefault(num, 0) + 1

        if (map[num]!! >= target) {
            println("YES")
            return
        }
    }

    for (i in 0 until n - m) {
        var num = q.pollFirst()!!

        map[num] = map[num]!! - 1
        num = st.nextToken().toInt()
        q.add(num)
        map[num] = map.getOrDefault(num, 0) + 1

        if (map[num]!! >= target) {
            println("YES")
            return
        }
    }

    println("NO")
}
