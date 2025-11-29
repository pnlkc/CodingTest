fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (t in 1..T) {
        val n = readln().toInt()
        val sL = readln().split("").drop(1).dropLast(1)
        var minusIdx = -1
        var result = true

        for (i in 0 until 2 * n + 1) {
            when (sL[i]) {
                "+" -> continue
                "-" -> if (minusIdx == -1) minusIdx = i
                else -> {
                    if (minusIdx != -1 && minusIdx != i - 1 && sL[i] != "0") {
                        result = false
                        break
                    }
                }
            }
        }

        sb.appendLine(if (result) "YES" else "NO")
    }

    print(sb)
}