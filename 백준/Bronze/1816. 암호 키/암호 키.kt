fun main() {
    val sb = StringBuilder()
    val N = readln().toInt()

    p@ for (tc in 1..N) {
        val S = readln().toLong()

        for (i in 2..1_000_000) {
            if (S % i == 0L) {
                sb.appendLine("NO")
                continue@p
            }
        }

        sb.appendLine("YES")
    }

    print(sb)
}