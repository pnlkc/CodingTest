fun main() {
    val n = readln().toInt()
    val arr = BooleanArray(24 * 60 + 1)
    var result = 0
    var cnt = 0

    for (i in 0 until n) {
        val (s, e) = readln().split(" ")
        val st = calc(s) - 10
        val et = calc(e) + 10

        for (j in maxOf(0, st) until minOf(et, 1440)) {
            arr[j] = true
        }
    }

    for (i in 600 until 1320) {
        if (arr[i]) {
            result = maxOf(result, cnt)
            cnt = 0
        } else {
            result = maxOf(result, ++cnt)
        }
    }

    println(result)
}

fun calc(str: String): Int {
    return str.slice(0..1).toInt() * 60 + str.slice(2..3).toInt()
}