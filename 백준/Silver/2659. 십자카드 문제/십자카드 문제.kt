var isEnd = false
var cnt = 0

fun main() {
    val arr = readln().split(" ").map { it.toInt() }
    val min = check(arr.joinToString("").toInt())

    calc(0, 0, min)
    println(cnt)
}

fun check(num: Int): Int {
    var min = 9999
    val arr = listOf(num / 1000, num % 1000 / 100, num % 100 / 10, num % 10)

    for (i in 0..3) {
        var result = ""

        for (j in i..3) {
            result += arr[j]
        }

        for (j in 0 until i) {
            result += arr[j]
        }

        min = minOf(min, result.toInt())
    }

    return min
}

fun calc(pos: Int, num: Int, target: Int) {
    if (isEnd) return

    if (pos == 4) {
        if (check(num) == num) {
            cnt++
            if (target == num) isEnd = true
        }
        return
    }

    for (i in 1..9) {
        calc(pos + 1, num * 10 + i, target)
    }
}