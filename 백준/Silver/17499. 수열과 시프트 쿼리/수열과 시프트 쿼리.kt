import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()
    val (N, Q) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }.toIntArray()
    var idx = 0

    repeat(Q) {
        val st = StringTokenizer(readln())

        when (st.nextToken().toInt()) {
            1 -> {
                val i = st.nextToken().toInt() - 1
                val x = st.nextToken().toInt()

                arr[(idx + i) % N] += x
            }
            2 -> {
                val s = st.nextToken().toInt()

                idx = (idx + N - (s % N)) % N
            }
            3 -> {
                val s = st.nextToken().toInt()

                idx = (idx + s) % N
            }
        }
    }

    for (i in idx until N) {
        if (sb.isNotEmpty()) sb.append(" ")
        sb.append(arr[i])
    }

    for (i in 0 until idx) {
        if (sb.isNotEmpty()) sb.append(" ")
        sb.append(arr[i])
    }

    println(sb)
}