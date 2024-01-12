fun main() {
    val N = readln().toInt()
    var sum = 3
    var num = 1

    while (sum < N) {
        sum *= 2
        sum += 3 + num
        if (sum < N) num++
    }

    calc(1, sum, num + 3, 0, N)
}

fun calc(s: Int, e: Int, num: Int, pos: Int, N: Int) {
    if (e - s < 3 || pos == 1) {
        if (N in s..e) {
            println(if (s == N) "m" else "o")
            return
        }
    }

    if (pos == 1) return

    val half = (e - s - num + 1) / 2

    if (N in s until s + half) calc(s, s + half - 1, num - 1, 0, N)
    if (N in s + half until s + half + num) calc(s + half, s + half + num - 1, num - 1, 1, N)
    if (N in s + half + num..e) calc(s + half + num, e, num - 1, 2, N)
}