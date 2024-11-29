import java.util.Stack
import java.util.StringTokenizer

fun main() {
    val N = readln().toInt()
    val s = Stack<Pair<Int, Int>>()
    var r = 0

    for (t in 1..N) {
        val st = StringTokenizer(readln())
        if (st.nextToken().toInt() == 0) {
            if (s.isNotEmpty()) {
                val c = s.pop()!!
                s.push(c.first to c.second - 1)
            }
        } else {
            val A = st.nextToken().toInt()
            val T = st.nextToken().toInt()

            s.push(A to T - 1)
        }

        if (s.isNotEmpty() && s.peek().second == 0) {
            r += s.pop()!!.first
        }
    }

    println(r)
}