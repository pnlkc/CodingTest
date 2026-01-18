import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()
    val t = readln().toInt()
    var st: StringTokenizer

    for (tc in 1..t) {
        st = StringTokenizer(readln())

        val a = st.nextToken().toLong()
        val n = st.nextToken().toInt()
        val str = a.toString(n)

        sb.appendLine(if (str == str.reversed()) 1 else 0)
    }

    print(sb)
}