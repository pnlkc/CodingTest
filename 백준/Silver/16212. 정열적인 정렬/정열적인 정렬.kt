fun main() {
    val N = readln()
    val list = readln().split(" ").map { it.toInt() }

    println(list.sorted().joinToString(" "))
}