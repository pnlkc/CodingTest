import java.util.Stack

fun main() {
    val input = readln()
    val stack = Stack<Char>()

    for (c in input) {
        if (stack.size >= 3) {
            if (c == 'P') {
                val z = stack.pop()!!
                val y = stack.pop()!!
                val x = stack.pop()!!

                if (x != 'P' || y != 'P' || z != 'A') {
                    stack.push(x)
                    stack.push(y)
                    stack.push(z)

                }

                stack.push(c)
            } else {
                stack.push(c)
            }
        } else {
            stack.push(c)
        }
    }

    println(if (stack.size == 1 && stack.peek() == 'P') "PPAP" else "NP")
}