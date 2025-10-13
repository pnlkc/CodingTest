fun main() {
    val k = readln().toInt()
    val (a, b, c, d) = readln().split(" ").map { it.toInt() }

    println(if (a.toLong() * k + b == c.toLong() * k + d) "Yes ${a.toLong() * k + b}" else "No")
}