var x = 0
var list = listOf<Int>()
var used = intArrayOf()
var s = 0
var result = 0

fun main() {
    x = readln().toInt()
    list = x.toString().split("").filter { it != "" }.map { it.toInt() }.sorted()
    s = list.size
    used = IntArray(s) { -1 }
    calc(0)
    println(result)
}

fun calc(idx: Int) {
    if (idx >= s) {
        val num = used.map { list[it] }.joinToString("").toInt()

        if (num > x) {
            result = if (result == 0) num else minOf(result, num)
        }

        return
    }

    p@ for (i in 0 until s) {
        for (j in 0 until idx) {
            if (used[j] == i) continue@p
        }

        used[idx] = i
        calc(idx + 1)
    }
}