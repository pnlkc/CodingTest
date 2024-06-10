var cnt = 0

fun main() {
    val (N, M, K) = readln().split(" ").map { it.toInt() }

    pick(N, M, K, 1, mutableListOf())

    var total = 1
    (N downTo N - M + 1).forEach { total *= it }
    (1..M).forEach { total /= it }

    println(cnt.toDouble() / total)
}

fun pick(n: Int, m: Int, k: Int, num: Int, pick: MutableList<Int>) {
    if (num > n) {
        if (pick.size == m && pick.count { it in 1..m } >= k) cnt++
        return
    }

    val temp = pick.toMutableList()
    temp.add(num)
    pick(n, m, k, num + 1, temp)
    pick(n, m, k, num + 1, pick)
}