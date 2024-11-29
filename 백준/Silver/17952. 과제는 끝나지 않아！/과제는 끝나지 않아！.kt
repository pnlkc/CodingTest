import java.util.Stack

data class D(val x: Int, val y: Int)

fun main() {
    val N = readln().toInt()
    val s = Stack<D>()
    var r = 0

    repeat(N) {
        val l = readln().split(" ").map { it.toInt() }
        when (l[0]) {
            0 -> if (s.isNotEmpty()) s.push(s.pop().let { D(it.x, it.y - 1) })
            1 -> s.push(D(l[1], l[2] - 1))
        }
        if (s.isNotEmpty() && s.peek().y == 0) r += s.pop().x
    }

    println(r)
}
