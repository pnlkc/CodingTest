val N = readln().toLong()
val list = mutableListOf<Long>(1, 1)
var result = false

fun main() {
    val MAX = 1_000_000_000_000_000_000
    var sum = 1L
    var num = 2

    while (true) {
        sum *= num++
        list.add(sum)

        if (MAX / num < sum) break
    }

    calc(0, 0)

    println(if (result) "YES" else "NO")
}

fun calc(i: Int, n: Long) {
    if (result) return
    if (n > N) return

    if (i > list.lastIndex) {
        if (N != 0L && n == N) result = true

        return
    }

    calc(i + 1, n)
    calc(i + 1, n + list[i])
}