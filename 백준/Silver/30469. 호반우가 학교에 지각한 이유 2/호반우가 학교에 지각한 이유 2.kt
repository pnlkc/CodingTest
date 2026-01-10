val pArr = BooleanArray(100) { true }
val map = Array(10) { mutableListOf<Int>() }
var result = intArrayOf()
var find = false

fun main() {
    val (a, b, n) = readln().split(" ").map { it.toInt() }

    result = IntArray(n)
    pArr[0] = false
    pArr[1] = false

    for (i in 2..99) {
        if (!pArr[i]) continue

        var num = i * 2

        while (num < 100) {
            pArr[num] = false
            num += i
        }
    }

    for (i in 11..99) {
        if (pArr[i]) map[i / 10].add(i % 10)
    }

    result[0] = a / 10
    result[1] = a % 10
    result[n - 2] = b / 10
    result[n - 1] = b % 10

    p@ for (idx in 1..n - 5) {
        for (i in map[result[idx]]) {
            result[idx + 1] = i
            continue@p
        }
    }

    for (i in map[result[n - 4]]) {
        for (j in map[i]) {
            if (j == b / 10) {
                result[n - 3] = i
                println(result.joinToString(""))
                find = true
                return
            }
        }
    }

    if (!find) println(-1)
}