fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    p1@for (tc in 1..T) {
        var N = readln().toInt()
        var result = ""

        p2@while (N != 1) {
            for (i in 9 downTo 2) {
                if (N % i == 0) {
                    result += i
                    N /= i
                    continue@p2
                }
            }

            sb.appendLine(-1)
            continue@p1
        }

        sb.appendLine(maxOf(1, result.length))
    }

    print(sb)
}