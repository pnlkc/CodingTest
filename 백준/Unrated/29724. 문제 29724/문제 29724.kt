fun main() {
    val n = readln().toInt()
    var sum = 0
    var cnt = 0

    repeat(n) {
        val (t, w ,h, l) = readln().split(" ")

        if (t == "A") {
            val temp = (w.toInt() / 12) * (h.toInt() / 12) * (l.toInt() / 12)
            cnt += temp
            sum += 1_000 + (500 * temp)
        } else {
            sum += 6_000
        }
    }

    println("$sum\n${cnt * 4_000}")
}
