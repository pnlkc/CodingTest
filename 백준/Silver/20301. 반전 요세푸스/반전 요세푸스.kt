import java.util.LinkedList

fun main() {
    val (N, K, M) = readln().split(" ").map { it.toInt() }
    val dq = LinkedList<Int>()
    val list = mutableListOf<Int>()

    for (i in 1..N) {
        dq.add(i)
    }

    var dir = true
    var cntK = 0
    var cntM = 0

    while (dq.isNotEmpty()) {
        val num = if (dir) dq.pollFirst()!! else dq.pollLast()!!

        if (++cntK == K) {
            if (++cntM == M) {
                dir = !dir

                cntM = 0
            }

            list.add(num)
            cntK = 0
        } else {
            if (dir) dq.addLast(num) else dq.addFirst(num)
        }
    }

    println(list.joinToString("\n"))
}