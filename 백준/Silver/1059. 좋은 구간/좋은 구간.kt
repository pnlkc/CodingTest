fun main() {
    val L = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.toMutableList()
    val n = readln().toInt()
    var cnt = 0

    list.add(0)
    list.sort()

    for (i in 0 until list.lastIndex) {
        if (list[i + 1] <= n || list[i] >= n) continue
        if (n !in list[i]..list[i + 1]) continue

        for (j in list[i] + 1 until list[i + 1]) {
            for (k in j + 1 until list[i + 1]) {
                if (n !in j..k) continue

                cnt++
            }
        }
    }

    println(cnt)
}