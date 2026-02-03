var n = 0
var list = listOf<Int>()
val cnt = IntArray(4)
var maxCnt = listOf<Int>()
var max = Int.MIN_VALUE
var min = Int.MAX_VALUE

fun main() {
    n = readln().toInt()
    list = readln().split(" "). map { it.toInt() }
    maxCnt = readln().split(" ").map { it.toInt() }

    calc(1, list[0])
    println("$max\n$min")
}

fun calc(idx: Int, num: Int) {
    if (idx == n) {
        max = maxOf(max, num)
        min = minOf(min, num)

        return
    }

    for (i in 0..3) {
        if (cnt[i] < maxCnt[i]) {
            cnt[i]++

            when (i) {
                0 -> calc(idx + 1, num + list[idx])
                1 -> calc(idx + 1, num - list[idx])
                2 -> calc(idx + 1, num * list[idx])
                3 -> calc(idx + 1, num / list[idx])
            }

            cnt[i]--
        }
    }
}