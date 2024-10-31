var isEnd = false

fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }.sortedDescending()

    calc(0, 0, N, list)
    calc(1, 0, N, list)
}

fun calc(idx: Int, num: Int, N: Int, list: List<Int>) {
    if (isEnd) return

    if (idx >= N.toString().length) {
        if (num <= N) {
            println(num)
            isEnd = true
        }
        return
    }

    for (n in list) {
        if (N.toString().slice(0..idx).toInt() >= num * 10 + n) {
            calc(idx + 1, num * 10 + n, N, list)
        }
    }
}