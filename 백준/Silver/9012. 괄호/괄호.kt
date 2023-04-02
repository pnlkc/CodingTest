import java.util.*

fun main() {
    val stack = Stack<Char>()

    repeat (readln().toInt()) {
        stack.clear()

        val s = readln()
        var result = true

        if (s.length % 2 != 0) result = false

        if (result) {
            for (c in s) {
                if (c == '(') {
                    stack.add(c)
                } else {
                    if (stack.isEmpty() || stack.pop()!! != '(') result = false
                }
            }
        }

        if (stack.isNotEmpty()) result = false

        println(if (result) "YES" else "NO")
    }
}