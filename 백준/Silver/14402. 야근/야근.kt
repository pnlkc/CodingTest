fun main() {
    val q = readln().toInt()
    val map = mutableMapOf<String, Int>()
    var result = 0

    repeat (q) {
        val (p, r) = readln().split(" ")

        if (r == "+") {
            map[p] = map.getOrDefault(p, 0) + 1
        } else {
            if (map[p] == null || map[p] == 0) {
                result++
            } else {
                map[p] = map[p]!! - 1
            }
        }
    }

    for ((k, v) in map) {
        result += v
    }

    println(result)
}