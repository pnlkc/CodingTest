fun main() {
    val N = readln().toInt()
    val map = mutableMapOf<Int, Int>()
    var cnt = 0

    for (i in 0 until N) {
        val (a, b) = readln().split(" ").map { it.toInt() }

        if (b == 1) {
            if (map[a] != null && map[a] == 1) cnt++
            map[a] = 1
        } else {
            if (map[a] == null || map[a] == 0) cnt++
            map[a] = 0
        }
    }

    for ((k, v) in map) {
        if (v == 1) cnt++
    }

    println(cnt)
}