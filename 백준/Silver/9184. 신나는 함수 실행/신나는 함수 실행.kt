fun main() {
    val map = mutableMapOf<String, Int>()
    while (true) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        if (a == -1 && b == -1 && c == -1) break
        println("w($a, $b, $c) = ${w(a, b, c, map)}")
    }
}

fun w(a: Int, b: Int, c: Int, map: MutableMap<String, Int>): Int {
    if (map["$a $b $c"] != null) return map["$a $b $c"]!!

    val result = when {
        a <= 0 || b <= 0 || c <= 0 -> 1
        a > 20 || b > 20 || c > 20 -> w(20, 20, 20, map)
        b in (a + 1) until c -> w(a, b, c - 1, map) + w(a, b - 1, c - 1, map) - w(a, b - 1, c, map)
        else -> w(a - 1, b, c, map) + w(a - 1, b - 1, c, map) + w(a - 1, b, c - 1, map) - w(a - 1, b - 1, c - 1, map)
    }

    map["$a $b $c"] = result

    return result
}