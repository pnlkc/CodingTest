import java.util.Stack

fun main() {
    val stack = Stack<Int>()
    var (a, b) = readln().split(' ')
    val diff = a.length - b.length
    if (diff > 0) b = "0".repeat(diff) + b else if (diff < 0) a = "0".repeat(-diff) + a
    var n = 0

    for (i in a.lastIndex downTo 0) {
        val sum = a[i].digitToInt() + b[i].digitToInt() + n
        n = sum / 2
        stack.push(sum % 2)
    }

    if (n != 0) stack.push(n)

    while (stack.isNotEmpty() && stack.peek() == 0) {
        stack.pop()
    }

    println(if (stack.isEmpty()) "0" else stack.joinToString("").reversed())
}