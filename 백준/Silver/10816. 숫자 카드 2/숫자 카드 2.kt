fun main() {
    val n = readln().toInt()
    val nMap = mutableMapOf<Int, Int>()
    readln().split(" ").forEach {
        val num = it.toInt()
        if (nMap[num] == null) nMap[num] = 1 else nMap[num] = nMap[num]!! + 1
    }
    val m = readln().toInt()
    val mList = readln().split(" ").map {
        if (nMap[it.toInt()] == null) 0 else nMap[it.toInt()]
    }
    println(mList.joinToString(" "))
}