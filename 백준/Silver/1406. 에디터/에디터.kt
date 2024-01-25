import java.util.LinkedList
import java.util.Stack

fun main() {
    val str = readln()
    val M = readln().toInt()
    val f = Stack<Char>()
    val b = LinkedList<Char>()

    for (i in str.indices) {
        f.push(str[i])
    }

    for (i in 1..M) {
        val input = readln().split(" ")

        when (input[0]) {
            "L" -> if (f.isNotEmpty()) b.addFirst(f.pop())
            "D" -> if (b.isNotEmpty()) f.push(b.pollFirst())
            "B" -> if (f.isNotEmpty()) f.pop()
            "P" -> f.push(input[1][0])
        }
    }

    println(f.joinToString("") + b.joinToString(""))
}