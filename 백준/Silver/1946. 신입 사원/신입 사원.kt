import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val N = readln().toInt()
        val arr = IntArray(N)
        var st: StringTokenizer

        for (i in 1..N) {
            st = StringTokenizer(readln())
            arr[st.nextToken().toInt() - 1] = st.nextToken().toInt()
        }

        var r = 0
        var min = Int.MAX_VALUE

        for (num in arr) {
            if (num < min) {
                min = num
                r++
            }
        }

        sb.appendLine(r)
    }

    print(sb)
}