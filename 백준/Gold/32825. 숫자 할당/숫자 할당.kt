var list = listOf<Int>()
val pick = IntArray(13)
var result = 0

fun main() {
    list = readln().split(" ").map { it.toInt() }
    calc(0)
    println(result)
}

fun calc(idx: Int) {
    if (idx == 13) {
        result++
        return
    }

    p@ for (i in 1..13) {
        for (j in 0 until idx) {
            if (pick[j] == i) continue@p
        }

        pick[idx] = i
        if (check(idx)) calc(idx + 1)
    }
}

fun check(idx: Int): Boolean  {
    if (idx == 11 && list[0] != pick[0] + pick[4] + pick[8] + pick[11]) return false
    if (idx == 12 && list[1] != pick[1] + pick[5] + pick[9] + pick[12]) return false
    if (idx == 10 && list[2] != pick[2] + pick[6] + pick[10]) return false
    if (idx == 7 && list[3] != pick[3] + pick[7]) return false
    if (idx == 3 && list[4] != pick[0] + pick[1] + pick[2] + pick[3]) return false
    if (idx == 7 && list[5] != pick[4] + pick[5] + pick[6] + pick[7]) return false
    if (idx == 10 && list[6] != pick[8] + pick[9] + pick[10]) return false
    if (idx == 12 && list[7] != pick[11] + pick[12]) return false

    return true
}