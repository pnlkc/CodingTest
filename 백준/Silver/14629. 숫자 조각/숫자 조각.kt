import kotlin.math.abs

var n = 0L
val isUsed = BooleanArray(10)
var pick = intArrayOf()
var diff = Long.MAX_VALUE
var result = Long.MAX_VALUE
var len = 0

fun main() {
    val N = readln().toLong()

    n = N
    len = n.toString().length
    pick = IntArray(10)

    if (n >= 9_876_543_210) {
        println(9_876_543_210)
        return
    }

    if (len > 1) {
        isUsed[9] = true
        pick[11 - len] = 9
        calc(12 - len)
        isUsed[9] = false
    }

    calc(10 - len)

    if (len < 10) {
        isUsed[1] = true
        pick[9 - len] = 1
        calc(10 - len)
        isUsed[1] = false
    }

    println(result)
}

fun calc(idx: Int) {
    if (idx == 10) {
        val num = pick.joinToString("").toLong()

        if (diff > abs(n - num)) {
            diff = abs(n - num)
            result = num
        } else if (diff == abs(n - num)) {
            result = minOf(result, num)
        }

        return
    }

    val range = if (idx == 0) 1..9 else 0..9

    for (i in range) {
        if (!isUsed[i]) {
            isUsed[i] = true
            pick[idx] = i
            calc(idx + 1)
            isUsed[i] = false
        }
    }
}