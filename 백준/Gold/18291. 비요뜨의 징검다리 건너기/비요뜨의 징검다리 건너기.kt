val NUM = 1_000_000_007

fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()
    val map = mutableMapOf(0 to 1L, 1 to 2L)

    for (i in 0 until T) {
        val N = readln().toInt() - 2

        sb.appendLine(
            when {
                N <= 0 -> 1
                map[N] != null -> map[N]
                else -> calc(N, map)
            }
        )
    }
    
    print(sb)
}

fun calc (n: Int, map: MutableMap<Int, Long>): Long {
    if (map[n] != null) return map[n]!!

    val half = calc(n / 2, map)
    var result = half * half % NUM

    if (n % 2 != 0) result *= 2

    map[n] = result % NUM
    return map[n]!!
}