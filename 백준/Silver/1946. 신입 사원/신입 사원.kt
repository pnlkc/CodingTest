import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val N = readln().toInt()
        val list = mutableListOf<Pair<Int, Int>>()
        var st: StringTokenizer

        for (i in 1..N) {
            st = StringTokenizer(readln())
            list.add(st.nextToken().toInt() to st.nextToken().toInt())
        }

        list.sortBy { it.first }

        var r = 0
        var min = Int.MAX_VALUE

        for (pair in list) {
            if (pair.second < min) {
                min = pair.second
                r++
            }
        }

        sb.appendLine(r)
    }

    print(sb)
}