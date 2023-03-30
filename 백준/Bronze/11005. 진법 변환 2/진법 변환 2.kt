fun main() {
    val (n, b) = readln().split(" ").map { it.toInt() }
    println(n.toString(b).uppercase())
}