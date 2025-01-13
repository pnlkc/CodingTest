fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    p@ for (tc in 1..T) {
        val str = readln()
        val arr = IntArray(26)
        var idx = 0

        while (idx < str.length) {
            if (++arr[str[idx] - 'A'] % 3 == 0) {
                if (idx < str.lastIndex && arr[str[idx] - 'A'] == arr[str[idx + 1] - 'A']) {
                    idx += 2
                } else {
                    sb.appendLine("FAKE")
                    continue@p
                }
            } else {
                idx++
            }
        }

        sb.appendLine("OK")
    }

    print(sb)
}