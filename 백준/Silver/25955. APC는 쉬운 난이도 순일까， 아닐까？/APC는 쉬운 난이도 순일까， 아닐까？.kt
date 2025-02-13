fun main() {
    val map =
        mutableMapOf('B' to 10_000, 'S' to 20_000, 'G' to 30_000, 'P' to 40_000, 'D' to 50_000)
    val N = readln().toInt()
    val list = readln().split(" ").map {
        it[0] to it.drop(1).toInt()
    }
    val sortedList = list.sortedWith(compareBy<Pair<Char, Int>> { map[it.first]!! }.thenByDescending { it.second })

    val result = mutableListOf<String>()

    for (i in 0 until N) {
        if (list[i] != sortedList[i]) result.add("${sortedList[i].first}${sortedList[i].second}")
    }

    println(if (result.isEmpty()) "OK" else "KO\n${result[0]} ${result[1]}")
}