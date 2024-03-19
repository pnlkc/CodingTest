data class Data(val name: String, val d: Int, val m: Int, val y: Int)

fun main() {
    val n = readln().toInt()
    val list = mutableListOf<Data>()

    for (i in 1..n) {
        val (name, d, m, y) = readln().split(" ")

        list.add(Data(name, d.toInt(), m.toInt(), y.toInt()))
    }

    list.sortWith(compareBy<Data> { it.y }.thenBy { it.m }.thenBy { it.d })

    println(list.last().name)
    println(list.first().name)
}