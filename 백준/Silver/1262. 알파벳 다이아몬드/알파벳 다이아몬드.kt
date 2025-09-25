import kotlin.math.abs

fun main() {
    val sb = StringBuilder()
    val (n, r1, c1, r2, c2) = readln().split(" ").map { it.toInt() }

    for (i in r1..r2) {
        for (j in c1..c2) {
            sb.append(calc(i, j, n))
        }

        sb.appendLine()
    }

    print(sb)
}

fun calc(r: Int, c: Int, n: Int): Char {
    val num = n * 2 - 1
    val row = r % num
    val col = c % num
    val dist = abs(row - n + 1) + abs(col - n + 1)

    if (dist >= n) return '.'

    val list = ('a'..'z').map { it }

    return list[dist % 26]
}