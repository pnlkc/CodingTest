fun main() {
    val n = readln().toInt()
    val nMap = mutableMapOf<Int, Boolean>()
    readln().split(" ").map { it.toInt() }.forEach { nMap[it] = true }
    val m = readln().toInt()
    val mList = readln().split(" ").map { it.toInt() }
    println(mList.map { if (nMap[it] == true) 1 else 0 }.joinToString(" "))
}