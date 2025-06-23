import java.util.LinkedList

fun main() {
    val S = readln()
    val deque = LinkedList<Int>()

    for (i in S.length - 1 downTo 0) {
        when (S[i]) {
            'f' -> {
                if (deque.size < 2) {
                    println(-1)
                    return
                }

                val a = deque.pollLast()!!
                val b = deque.pollLast()!!

                deque.add(minOf(a, b))
            }
            'g' -> {
                if (deque.isEmpty()) {
                    println(-1)
                    return
                }

                deque.add(deque.pollLast()!! + 1)
            }
            'x' -> {
                deque.add(0)
            }
        }
    }

    println(if (deque.size != 1) -1 else deque.pollLast()!!)
}