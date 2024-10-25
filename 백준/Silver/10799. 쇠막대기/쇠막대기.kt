import java.util.Stack

fun main() {
    val input = readln()
    val s = Stack<Char>()
    var result = 0

    for (i in input.indices) {
        val c = input[i]

        if (c == '(') {
            s.push(c)
        } else {
            s.pop()
            result += if (i > 0 && input[i - 1] == '(') s.size else 1
        }
    }
    
    println(result)
}