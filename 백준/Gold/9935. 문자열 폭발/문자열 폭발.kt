import java.util.Stack

fun main() {
    val s = readln()
    val es = readln()
    val stack = Stack<Char>()
    val sb = StringBuilder()

    for (c in s) {
        stack.push(c)

        if (stack.size >= es.length) {
            var isDelete = true

            for (i in 0..es.lastIndex) {
                if (stack[stack.lastIndex - i] != es[es.lastIndex - i]) {
                    isDelete = false
                    break
                }
            }

            if (isDelete) {
                repeat(es.length) { stack.pop() }
            }
        }
    }

    println(
        if (stack.isEmpty()) {
            "FRULA"
        } else {
            while (stack.isNotEmpty()) {
                sb.append(stack.pop())
            }
            sb.reverse().toString()
        }
    )
}