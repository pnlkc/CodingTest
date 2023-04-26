import java.util.Stack
import java.util.StringTokenizer

fun main() {
    val stack = Stack<Int>()
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val a = IntArray(n) { st.nextToken().toInt() }

    for (i in 0 until n) {
        while (stack.isNotEmpty()) {
            if (a[stack.peek()] >= a[i]) break
            a[stack.peek()] = a[i]
            stack.pop()
        }

        stack.add(i)
    }

    while (stack.isNotEmpty()) {
        a[stack.pop()] = -1
    }

    println(a.joinToString(" "))
}