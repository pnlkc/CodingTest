fun main() {
    val sb = StringBuilder()
    val str = readln()
    val pick = CharArray(str.length) { ' ' }

    repeat(str.length) {
        var min = ""
        var idx = 0

        for (i in str.indices) {
            if (pick[i] != ' ') continue

            pick[i] = str[i]

            val cStr = pick.filter { it != ' ' }.joinToString("")

            if (min == "" || cStr < min) {
                min = cStr
                idx = i
            }

            pick[i] = ' '
        }

        pick[idx] = str[idx]
        sb.appendLine(min)
    }

    print(sb)
}