var max = 0
var result = -1

fun main() {
    val (N, d) = readln().split(" ").map { it.toInt() }

    max = when (d) {
        2 -> "10".toInt(2)
        3 -> "210".toInt(3)
        4 -> "3210".toInt(4)
        5 -> "43210".toInt(5)
        6 -> "543210".toInt(6)
        7 -> "6543210".toInt(7)
        8 -> "76543210".toInt(8)
        else -> "876543210".toInt(9)
    }

    check("", 0, N, d)

    println(result)
}

fun check(str: String, idx: Int, n: Int, d: Int) {
    if (result != -1) return

    if (idx == d) {
        if (str.toInt(d) in n + 1..max) {
            result = str.toInt(d)
        }

        return
    }

    for (i in if (idx == 0) 1 until d else 0 until d) {
        if (!str.contains(i.toString())) {
            check(str + i, idx + 1, n, d)
        }
    }
}