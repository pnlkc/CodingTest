fun main() {
    val n = readln().toInt()
    val ns = n * n
    var cnt = 0
    var a = 0.0
    var b = -1.0

    while (true) {
        if (a == 0.0 && b == 0.0) break
        if (a == 0.0 && b > 0.0) break
        if (a > 0.0 && b > 0.0 && b > a) break

        if (a < 0 && a < b) {
            a *= -1
            cnt++
        } else {
            val na = ((1 - ns) * a + 2 * ns * b) / (1 + ns)
            val nb = (2 * a - (1 - ns) * b) / (1 + ns)

            a = na
            b = nb
            cnt++
        }
    }

    println(cnt)
}