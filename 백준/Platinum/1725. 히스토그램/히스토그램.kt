import java.util.Stack

fun main() {
    val n = readln().toInt()
    val arr = IntArray(n + 2)
    val stack = Stack<Int>()
    var r = 0

    (1..n).forEach { arr[it] = readln().toInt() }
    stack.push(0)

    for (i in 1..n + 1) {
        while (stack.isNotEmpty() && arr[i] < arr[stack.peek()]) {
            val c = stack.pop()
            r = maxOf(r, (i - stack.peek() - 1) * arr[c]) // 
        }

        stack.push(i)
    }

    println(r)
}