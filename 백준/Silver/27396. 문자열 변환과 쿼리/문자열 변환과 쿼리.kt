import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()
    val (s, n) = readln().split(" ")
    val map = mutableMapOf<Char, Char>()
    val arr = ('a'..'z').toList().toCharArray() + ('A'..'Z').toList()

    arr.forEach { map[it] = it }

    repeat(n.toInt()) {
        val st = StringTokenizer(readln())

        if (st.nextToken() == "1") {
            val a = st.nextToken()[0]
            val b = st.nextToken()[0]
            
            arr.forEach { c -> if (map[c] == a) map[c] = b }
        } else {
            s.forEach { c -> sb.append(map[c]!!) }
            sb.appendLine()
        }
    }

    print(sb)
}