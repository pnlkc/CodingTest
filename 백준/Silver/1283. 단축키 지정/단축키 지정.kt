fun main() {
    val sb = StringBuilder()
    val N = readln().toInt()
    val isUsed = BooleanArray(26)

    p@ for (n in 1..N) {
        val str = readln()
        val list = str.split(" ")

        for (i in list.indices) {
            val char = list[i][0]
            val idx = char.uppercaseChar() - 'A'

            if (!isUsed[idx]) {
                isUsed[idx] = true

                sb.appendLine(list.mapIndexed { index, s ->
                    if (index == i) {
                        s.replaceRange(0, 1, "[${s[0]}]")
                    } else {
                        s
                    }
                }.joinToString(" "))

                continue@p
            }
        }

        for (i in str.indices) {
            val char = str[i]
            val idx = char.uppercaseChar() - 'A'

            if (idx < 0) continue

            if (!isUsed[idx]) {
                isUsed[idx] = true

                sb.appendLine(str.replaceRange(i, i + 1, "[$char]"))

                continue@p
            }
        }

        sb.appendLine(str)
    }

    print(sb)
}