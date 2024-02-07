import java.util.Stack

fun main() {
    val str = readln()
    val sb = StringBuilder()
    val stack = Stack<Char>()
    var isTag = false

    for (i in str.indices) {
        when (str[i]) {
            '<' -> {
                while (stack.isNotEmpty()) {
                    sb.append(stack.pop())
                }

                isTag = true
                sb.append(str[i])
            }
            '>' -> {
                isTag = false
                sb.append(str[i])
            }
            ' ' -> {
                while (stack.isNotEmpty()) {
                    sb.append(stack.pop())
                }

                sb.append(str[i])
            }
            else -> if (isTag) sb.append(str[i]) else stack.push(str[i])
        }
    }

    while (stack.isNotEmpty()) {
        sb.append(stack.pop())
    }

    println(sb)
}