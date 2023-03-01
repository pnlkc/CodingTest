fun main() {
    val num = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val max = list.maxOrNull()!!
    println(list.map { it.toDouble() / max * 100 }.average())
}
