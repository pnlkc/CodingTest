fun main() {
    val input = readln().split(" ").map { it.reversed().toInt() }
    println(input.maxOrNull())
}