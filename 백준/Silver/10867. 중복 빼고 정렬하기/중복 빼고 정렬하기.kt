fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }

    println(list.distinct().sorted().joinToString(" "))
}
