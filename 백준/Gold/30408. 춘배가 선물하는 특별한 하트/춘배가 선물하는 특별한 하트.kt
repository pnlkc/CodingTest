val map = mutableMapOf<Long, Boolean>()

fun main() {
    val (N, M) = readln().split(" ").map { it.toLong() }

    map[N] = true
    calc(N)
    println(if (map[M] == null) "NO" else "YES")
}

fun calc(num: Long) {
    if (num == 1L) return

    if (num % 2 == 0L) {
        if (map[num / 2] == null) {
            map[num / 2] = true
            calc(num / 2)
        }
    } else {
        if (map[(num - 1) / 2] == null) {
            map[(num - 1) / 2] = true
            calc((num - 1) / 2)
        }

        if (map[(num - 1) / 2 + 1] == null) {
            map[(num - 1) / 2 + 1] = true
            calc((num - 1) / 2 + 1)
        }
    }
}