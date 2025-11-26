fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = mutableMapOf<Int, Int>()
    var oddCnt = 0
    var evenCnt = 0

    repeat(n) {
        val input = readln().split(" ").map { it.toInt() }

        for (i in 0 until m) {
            map[input[i]] = map.getOrDefault(input[i], 0) + 1
        }
    }

    for (key in map.keys) {
        if (map[key]!! % 2 == 0) evenCnt++ else oddCnt++
    }

    println(if (oddCnt != 0 && (m % 2 == 0 || oddCnt > n || (n - oddCnt) % 2 != 0)) "NO" else "YES")
}
