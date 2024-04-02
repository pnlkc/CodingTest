fun main() {
    val list = readln().split(" ").map { it.toInt() }
    println(list[1] * 2 - list[0])
}