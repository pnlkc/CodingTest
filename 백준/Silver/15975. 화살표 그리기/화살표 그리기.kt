fun main() {
    val N = readln().toInt()
    val map = mutableMapOf<Int, MutableList<Int>>()
    var result = 0L

    for (i in 0 until N) {
        val (x, y) = readln().split(" ").map { it.toInt() }

        if (map[y] == null) map[y] = mutableListOf(x) else map[y]!!.add(x)
    }

    map.keys.forEach {
        map[it]!!.sort()

        for (i in map[it]!!.indices) {
            result += when {
                i - 1 < 0 && i + 1 >= map[it]!!.size -> 0
                i - 1 < 0 -> map[it]!![i + 1] - map[it]!![i]
                i + 1 >= map[it]!!.size -> map[it]!![i] - map[it]!![i - 1]
                else -> minOf(
                    map[it]!![i + 1] - map[it]!![i],
                    map[it]!![i] - map[it]!![i - 1]
                )
            }
        }
    }

    println(result)
}