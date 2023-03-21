fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }.sorted()
    println(if (a + b <= c) (a + b) * 2 - 1 else a + b + c)
}