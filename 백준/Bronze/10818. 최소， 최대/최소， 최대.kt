fun main() {
    val size = readln()
    val list = readln().split(" ").map { it.toInt() }
    println("${list.minOrNull()} ${list.maxOrNull()}")
}