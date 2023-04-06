fun main() {
    val n = readln().toInt()
    var c = listOf(0, 0)
    val list = List(n) { readln().split(" ").map { it.toInt() } }
        .sortedWith(compareBy<List<Int>> { it[1] }.thenBy { it[0] })
    println(list.fold(0) { acc, ints -> if (ints[0] >= c[1]) (acc + 1).also { c = ints } else acc })
}