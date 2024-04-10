import java.util.StringTokenizer

fun main() {
    val T = readln().toInt()
    val sb = StringBuilder()

    for (i in 0 until T) {
        val N = readln().toInt()
        val st = StringTokenizer(readln())
        val map = mutableMapOf<Int, Boolean>()

        while (st.hasMoreTokens()) {
            map[st.nextToken().toInt()] = true
        }

        val M = readln().toInt()
        val list = readln().split(" ").map { it.toInt() }

        list.forEach {
            sb.appendLine(if (map[it] != null) 1 else 0)
        }
    }

    print(sb)
}