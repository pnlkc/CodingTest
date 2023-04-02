import java.util.*

fun main() {
    val n = readln().toInt()
    val stack = Stack<Int>()
    val s = StringBuilder()
    var max = 0

    repeat(n) {
        val c = readln().toInt()

        for (i in max + 1..c) {
            stack.push(i)
            s.append('+').append("\n")
        }

        if (stack.peek()!! != c) return println("NO")
        stack.pop()
        s.append('-').append("\n")
        max = maxOf(max, c)
    }

    println(s.toString())
}