fun main() {
    val N = readln().toInt()
    val input = readln()
    val map = IntArray(26)
    var cnt = 0
    var result = 0
    var max = 0

    var s = 0
    var e = 0

    while (e in s until input.length) {
        val c = input[e] - 'a'

        if (map[c] == 0) {
            if (cnt >= N) {
                map[input[s] - 'a'] = map[input[s] - 'a'] - 1
                result--
                if (map[input[s] - 'a'] == 0) cnt--
                s++
            } else {
                result++
                map[c] = 1
                e++
                cnt++
            }
        } else {
            result++
            map[c] = map[c] + 1
            e++
        }

        max = maxOf(max, result)
    }

    println(max)
}