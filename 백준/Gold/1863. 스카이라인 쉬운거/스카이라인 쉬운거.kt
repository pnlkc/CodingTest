import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    var st: StringTokenizer
    val stack = LinkedList<Int>()
    var result = 0

    repeat(n) {
        st = StringTokenizer(readln())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()

        while (stack.isNotEmpty() && stack.peekLast()!! >= y) {
            if (stack.pollLast()!! > y) result++
        }

        stack.addLast(y)
    }

    while (stack.isNotEmpty()) {
        if (stack.pollLast()!! > 0) result++
    }

    println(result)
}