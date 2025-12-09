fun main() {
    val sb = StringBuilder()
    val p = readln().toInt()

    for (tc in 1..p) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        var cnt = 0
        var a = 1
        var b = 1

        while (true) {
            if (cnt != 0 && a % m == 1 && b % m == 1) break

            val temp = b

            b = (a + b) % m
            a = temp
            cnt++
        }

        sb.appendLine("$n $cnt")
    }

    print(sb)
}