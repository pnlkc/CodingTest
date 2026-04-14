import java.util.LinkedList

fun main() {
    val stack = LinkedList<Int>()
    val str = readln()

    for (c in str) {
        if (c in '0'..'9') {
            stack.addLast(c.digitToInt())
        } else {
            val b = stack.pollLast()!!
            val a = stack.pollLast()!!

            stack.addLast(
                when (c) {
                    '+' -> a + b
                    '-' -> a - b
                    '*' -> a * b
                    else -> a / b
                }
            )
        }
    }

    println(stack.pollLast()!!)
}