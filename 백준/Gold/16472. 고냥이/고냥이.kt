fun main() {
    val N = readln().toInt()
    val input = readln()
    val map = mutableMapOf<Char, Int>()
    var cnt = 0
    var result = 0
    var max = 0

    ('a'..'z').forEach { map[it] = 0 }

    var s = 0
    var e = 0

    while (e in s until input.length) {
        val c = input[e]

        if (map[c] == 0) {
            if (cnt >= N) {
                map[input[s]] = map[input[s]]!! - 1
                result--
                if (map[input[s]] == 0) cnt--
                s++
            } else {
                cnt++
                map[c] = 1
                e++
                result++
            }
        } else {
            result++
            map[c] = map[c]!! + 1
            e++
        }

        max = maxOf(max, result)
    }

    println(max)
}