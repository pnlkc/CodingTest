fun main() {
    val (n, k) = readln().split(" ").map { it.toLong() }
    var s = 0L
    var e = n / 2

    while (s <= e) {
        val a = (s + e) / 2
        val b = n - a
        val num = (a + 1) * (b + 1)

        when {
            num == k -> {
                println("YES")
                return
            }
            num < k -> s = a + 1
            else -> e = a - 1
        }
    }

    println("NO")
}