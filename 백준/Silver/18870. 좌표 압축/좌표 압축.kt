fun main() {
    val testCaseNum = readln().toInt()
    val list = mutableListOf<Int>()
    list.addAll(readln().split(" ").map { it.toInt() })
    val sortList = list.distinct().sorted()
    val map = mutableMapOf<Int, Int>()
    sortList.forEachIndexed { index, i -> map[i] = index }
    println(list.map { map[it]!! }.joinToString(" "))
}