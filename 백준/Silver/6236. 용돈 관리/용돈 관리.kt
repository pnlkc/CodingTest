fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val list = IntArray(n)
    var s = 0
    var e = 0
    var answer = Int.MAX_VALUE

    for (i in 0 until n) {
        val num = readln().toInt()
        list[i] = num
        s = maxOf(s, num)
        e += num
    }

    while (s <= e) {
        val mid = (s + e) / 2
        var cnt = 0
        var money = 0

        for (i in 0 until n) {
            if (list[i] > money) {
                if (++cnt > m) break
                money = mid
            }

            money -= list[i]
        }

        if (cnt > m) {
            s = mid + 1
        } else {
            answer = minOf(answer, mid)
            e = mid - 1
        }
    }

    println(answer)
}