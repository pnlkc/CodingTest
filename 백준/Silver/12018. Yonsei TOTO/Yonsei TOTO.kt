fun main() {
    val (n, m) = readln().trim().split(" ").map { it.toInt() }
    val list = mutableListOf<Int>()

    for (i in 1..n) {
        val (p, l) = readln().trim().split(" ").map { it.toInt() }
        val pL = readln().trim().split(" ").map { it.toInt() }.sortedDescending()

        list.add(if (p < l) 1 else pL[l - 1])
    }

    list.sort()

    var sum = 0
    var ans = 0

    for (i in list.indices) {
        if (sum + list[i] <= m) {
            sum += list[i]
            ans = i + 1
        }
    }

    println(ans)
}