import java.util.Stack

fun main() {
    val N = readln().toInt()
    var cnt = 0

    for (i in 1..N) {
        val input = readln()
        val stack = Stack<Char>()

        if (input.length % 2 == 1) continue

        for (c in input) {
            when {
                stack.isEmpty() -> stack.push(c)
                else -> if (stack.peek() != c) stack.push(c) else stack.pop()
            }
        }

        if (stack.isEmpty()) cnt++
    }

    println(cnt)
}