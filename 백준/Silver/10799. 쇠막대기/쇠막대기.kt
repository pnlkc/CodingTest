import java.util.Stack

fun main() {
    val str = readln()
    val s = Stack<Char>()
    var r = 0

    for (i in str.indices) {
        if (str[i] == '(') {
            s.push(str[i])
        } else {
            s.pop()
            r += if (i > 0 && str[i - 1] == '(') s.size else 1
        }
    }

    println(r)
}