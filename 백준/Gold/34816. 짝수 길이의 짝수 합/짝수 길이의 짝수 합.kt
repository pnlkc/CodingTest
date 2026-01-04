import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()
    val (n, q) = readln().split(" ").map { it.toInt() }
    val arr = readln().toCharArray()
    var st: StringTokenizer

    p@ for (case in 1..q) {
        st = StringTokenizer(readln())

        if (st.nextToken().toInt() == 1) {
            val i = st.nextToken().toInt()

            arr[i - 1] = if (arr[i - 1] == '1') '0' else '1'
        } else {
            val x = st.nextToken().toInt()
            val y = st.nextToken().toInt()

            sb.appendLine(
                when {
                    x == y -> "NO"
                    y - x == 1 -> if (arr[x - 1] == arr[x]) "YES" else "NO"
                    y - x == 2 -> if (arr[x - 1] == arr[x] || arr[x] == arr[x + 1]) "YES" else "NO"
                    else -> "YES"
                }
            )
        }
    }
    
    print(sb)
}