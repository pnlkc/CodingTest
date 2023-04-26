fun main(args: Array<String>) {
    val (a, b) = readln().split(" ").map { it.toInt() }
    println("$a + $b = ${a + b}")
}