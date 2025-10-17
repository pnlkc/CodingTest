var result = 0L
val NUM = 1_000_000_007
var n = 0
var m = 0

fun main() {
    val input = readln().split(" ").map { it.toInt() }

    n = input[0]
    m = input[1]

    calc(0, 0, "", false)

    println(result)
}

fun calc(idx: Int, len: Int, r: String, can: Boolean) {
    if (n == idx) {
        if (len == m || can) {
            var sum = 1L

            for (i in 0 until n) {
                sum = if (r[i] == '0') sum * 11 % NUM else sum * 5 % NUM
            }

            result = (result + sum) % NUM
        }

        return
    }

    if (len == m) {
        if (r.isEmpty() || r.last() == '0') {
            calc(idx + 1, 1, r + "0", true)
        }

        if (r.isEmpty() || r.last() == '1') {
            calc(idx + 1, 1, r + "1", true)
        }

    } else {
        if (r.isEmpty()) {
            calc(idx + 1, 1, r + "0", can)
            calc(idx + 1, 1, r + "1", can)
        } else if (r.last() == '0') {
            calc(idx + 1, len + 1, r + "1", can)
            calc(idx + 1, 1, r + "0", can)
        } else if (r.last() == '1') {
            calc(idx + 1, len + 1, r + "0", can)
            calc(idx + 1, 1, r + "1", can)
        }
    }
}