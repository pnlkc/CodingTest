val base = mutableMapOf(
    1 to "I", 2 to "II", 3 to "III", 4 to "IV", 5 to "V",
    6 to "VI", 7 to "VII", 8 to "VIII", 9 to "IX",
    10 to "X", 20 to "XX", 30 to "XXX", 40 to "XL", 50 to "L",
    60 to "LX", 70 to "LXX", 80 to "LXXX", 90 to "XC"
)
val map = mutableMapOf(
    "I" to 1, "II" to 2, "III" to 3, "IV" to 4, "V" to 5,
    "VI" to 6, "VII" to 7, "VIII" to 8, "IX" to 9,
    "X" to 10, "XX" to 20, "XXX" to 30, "XL" to 40, "L" to 50,
    "LX" to 60, "LXX" to 70, "LXXX" to 80, "XC" to 90
)
var input = ""
var pick = intArrayOf()
var len = 0
var result = ""
var min = Int.MAX_VALUE

fun main() {
    input = readln()
    len = input.length
    pick = IntArray(len) { -1 }
    result = input

    for (i in 11..99) {
        if (i % 10 == 0) continue
        val key = base[i / 10 * 10]!! + base[i % 10]!!
        map[key] = i
    }

    pick(0)

    println(result)
}

fun pick(idx: Int) {
    if (idx >= len) {
        val num = map[pick.map { input[it] }.joinToString("")]

        if (num != null && min > num) {
            result = pick.map { input[it] }.joinToString("")
            min = num
        }

        return
    }

    p@ for (i in 0 until len) {
        for (j in 0 until idx) {
            if (pick[j] == i) continue@p
        }

        pick[idx] = i
        pick(idx + 1)
    }
}