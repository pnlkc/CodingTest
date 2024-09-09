fun main() {
    val sb = StringBuilder()

    while (true) {
        val (s, t) = readlnOrNull()?.split(" ") ?: break

        var ss = 0
        var ts = 0

        while (ts < t.length && ss < s.length) {
            if (s[ss] == t[ts]) ss++
            ts++
        }

        sb.appendLine(if (ss == s.length) "Yes" else "No")
    }

    print(sb)
}