import java.util.*

fun main() {
    val tcNum = readln().toInt()
    val queue = LinkedList<Int>()

    repeat(tcNum) {
        val pList = IntArray(10)
        val (n, m) = readln().split(" ").map { it.toInt() }
        val pInput = readln()
        val map =
            pInput.split(" ").mapIndexed { idx, s -> idx + 1 to s.toInt() }.toMap().toMutableMap()
        val st = StringTokenizer(pInput)

        while (st.hasMoreTokens()) {
            pList[st.nextToken().toInt()]++
        }

        queue.clear()
        queue.addAll(1..n)

        while (true) {
            val c = queue.poll()!!
            var max = 0
            for (i in 9 downTo 1) {
                max = i
                if (pList[i] > 0) break
            }

            if (map[c]!! < max) queue.add(c)
            else if (c == m + 1) break
            else pList[map[c]!!]--
        }

        println(n - queue.size)
    }
}