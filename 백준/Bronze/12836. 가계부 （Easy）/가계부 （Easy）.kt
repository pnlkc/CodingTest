fun main() {
    val sb = StringBuilder()
    val (n, q) = readln().split(" ").map { it.toInt() }
    val arr = LongArray(n + 1)

    for (i in 1..q) {
        val (c, a, b) = readln().split(" ").map { it.toInt() }

        if (c == 1) {
            arr[a] = arr[a] + b
        } else {
            var result = 0L

            for (j in a..b) {
                result += arr[j]
            }

            sb.appendLine(result)
        }
    }

    print(sb)
}