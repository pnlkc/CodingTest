import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()
    var st = StringTokenizer("")
    val q = readln().toInt()
    val dq = LinkedList<String>()
    var pos = 0
    var cntB = 0
    var cntW = 0

    fun clear() {
        when (pos) {
            1 -> {
                while (dq.isNotEmpty() && dq.peekFirst() == "b") {
                    dq.pollFirst()
                    cntB--
                }
            }
            3 -> {
                while (dq.isNotEmpty() && dq.peekLast() == "b") {
                    dq.pollLast()
                    cntB--
                }
            }
        }
    }

    for (i in 0 until q) {
        st = StringTokenizer(readln())
        val command = st.nextToken()
        val type = if (st.hasMoreTokens()) st.nextToken() else ""

        when (command) {
            "push" -> {
                if (type == "b") if (pos == 3 || (pos == 1 && dq.isEmpty())) continue
                dq.add(type)
                if (type == "b") cntB++ else cntW++
            }
            "pop" -> {
                if (dq.isNotEmpty()) if (dq.pop() == "b") cntB-- else cntW--
                clear()
            }
            "rotate" -> {
                pos = if (type == "l") (pos + 3) % 4 else (pos + 1) % 4
                clear()
            }
            "count" -> sb.appendLine(if (type == "b") cntB else cntW)
        }
    }

    print(sb)
}