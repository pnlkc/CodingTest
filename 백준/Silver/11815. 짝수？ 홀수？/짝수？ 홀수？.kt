import java.util.StringTokenizer
import kotlin.math.sqrt

fun main() {
    val sb = StringBuilder()
    val N = readln().toInt()
    val st = StringTokenizer(readln())

    for (i in 0 until N) {
        val X = st.nextToken().toLong()
        val sqrt = sqrt(X.toDouble()).toLong()

        sb.append(if (sqrt * sqrt == X) 1 else 0)
        if (i != N - 1) sb.append(" ")
    }

    println(sb)
}