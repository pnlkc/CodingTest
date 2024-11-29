import java.util.Stack

data class D(val x: Int, val y: Int)

fun main() {
    val N = readln().toInt()
    val s = Stack<D>()
    var r = 0

    for (t in 1..N) {
        val l = readln().split(" ").map { it.toInt() }
        
        if (l[0] == 0 && s.isNotEmpty()) {
            val c = s.pop()!!
            s.push(D(c.x, c.y - 1))
        }
        if (l[0] == 1) s.push(D(l[1], l[2] - 1))

        if (s.isNotEmpty() && s.peek().y == 0) r += s.pop()!!.x
    }

    println(r)
}