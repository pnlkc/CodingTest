fun main() {
    val condition = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    println(list.filter { it < condition[1] }.joinToString(" "))
}