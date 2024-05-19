import java.util.LinkedList

fun main() {
    val input = readln()
    val q = LinkedList<Char>()
    q.offer('U')
    q.offer('C')
    q.offer('P')
    q.offer('C')

    for (c in input) {
        if (q.isEmpty()) break
        if (q.peek() == c) q.poll()
    }

    println(if (q.isEmpty()) "I love UCPC" else "I hate UCPC")
}