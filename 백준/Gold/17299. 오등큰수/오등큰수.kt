import java.util.Stack
import java.util.StringTokenizer

fun main() {
    val stack = Stack<Int>()
    val map = mutableMapOf<Int, Int>()
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val a = IntArray(n) { 
        val num = st.nextToken().toInt()
        if (map[num] == null) map[num] = 1 else map[num] = map[num]!! + 1
        num
    }
    
    for (i in 0 until n) {
        while (stack.isNotEmpty()) {
            if ((map[a[stack.peek()]] ?: 0) >= (map[a[i]] ?: 0)) break
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