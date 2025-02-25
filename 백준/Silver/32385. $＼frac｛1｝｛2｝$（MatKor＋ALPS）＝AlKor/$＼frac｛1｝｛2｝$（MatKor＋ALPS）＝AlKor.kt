import java.util.LinkedList

fun main() {
    val sb = StringBuilder()
    val N = readln().toInt()
    val q = LinkedList<Int>()

    for (i in 1..N / 2) {
        if (i == N / 2 && N % 2 != 0) {
            q.addFirst(-i)
            q.addFirst(-i - 1)
            q.addLast(i + i + 1)
        } else {

            q.addFirst(-i)
            q.addLast(i)
        }
    }

    while (q.isNotEmpty()) {
        val c = q.poll()!!

        sb.append("$c ")
    }

    print(sb)
    print("0\n")
}