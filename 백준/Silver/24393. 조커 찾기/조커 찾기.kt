import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val N = readln().toInt()
    val arr = Array(N) { IntArray(28) }
    val d = LinkedList<Int>()
    val l = LinkedList<Int>()
    val r = LinkedList<Int>()

    for (i in 0 until N) {
        val st = StringTokenizer(readln())
        var idx = 1

        while (st.hasMoreTokens()) {
            arr[i][idx++] = st.nextToken().toInt()
        }
    }

    for (i in 1..27) {
        d.add(i)
    }

    for (i in 0 until N) {
        repeat(13) {
            l.add(d.poll()!!)
        }

        repeat(14) {
            r.add(d.poll()!!)
        }

        for (j in 1..27) {
            for (k in 1..arr[i][j]) {
                if (j % 2 == 1) {
                    d.add(r.poll()!!)
                } else {
                    d.add(l.poll()!!)
                }
            }
        }
    }

    for (i in 0 until 27) {
        val num = d.poll()!!

        if (num == 1) {
            println(i + 1)
            break
        }
    }
}