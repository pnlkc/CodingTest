fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.sorted()
    println(list.first().toLong() * list.last().toLong())
}