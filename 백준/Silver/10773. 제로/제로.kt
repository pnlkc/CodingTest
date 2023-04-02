import java.util.*

fun main() {
    var sum = 0L
    val stack = Stack<Int>()

    repeat (readln().toInt()) {
        val n = readln().toInt()

        if (n == 0) {
            sum -= stack.pop()!!
        } else {
            sum += n
            stack.add(n)
        }
    }

    println(sum)
}