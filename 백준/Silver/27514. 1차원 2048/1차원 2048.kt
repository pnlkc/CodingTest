fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toLong() }
    val map = mutableMapOf<Long, Int>()
    var result = 0L
    var num = 1L

    for (i in 0 until n) {
        map[list[i]] = map.getOrDefault(list[i], 0) + 1
    }

    if (map[1L] != null) result = 1L

    repeat(62) {
        map[num * 2] = map.getOrDefault(num * 2, 0) + map.getOrDefault(num, 0) / 2
        num *= 2
        if (map[num] != null && map[num] != 0) result = num
    }

    println(result)
}