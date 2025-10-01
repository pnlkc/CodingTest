import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()
    val (n, m, q) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until m) {
            arr[i][j] = input[j]
        }
    }

    repeat(q) {
        val st = StringTokenizer(readln())

        if (st.nextToken() == "0") {
            arr[st.nextToken().toInt()][st.nextToken().toInt()] = st.nextToken().toInt()
        } else {
            val i = st.nextToken().toInt()
            val j = st.nextToken().toInt()

            val temp = arr[i]

            arr[i] = arr[j]
            arr[j] = temp
        }
    }

    for (i in 0 until n) {
        sb.appendLine(arr[i].joinToString(" "))
    }

    print(sb)
}