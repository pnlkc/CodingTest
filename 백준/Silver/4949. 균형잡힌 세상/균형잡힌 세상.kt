import java.util.*

fun main() {
    val stack = Stack<Char>()
    val map = mapOf(']' to '[', ')' to '(')

    p@while (true) {
        stack.clear()

        val s = readln().takeIf { it != "." } ?: break
        val filterS = s.filter { !it.isLetter() && it != '.' }.replace(" ", "")

        for (c in filterS) {
            if (c == '(' || c == '[') {
                stack.add(c)
            } else {
                if (stack.isEmpty() || map[c] != stack.pop()!!) {
                    println("no")
                    continue@p
                }
            }
        }

        println(if (stack.isNotEmpty()) "no" else "yes")
    }
}