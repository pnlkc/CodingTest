fun main() {
    val d = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }

    println(list.count { it == d })
}