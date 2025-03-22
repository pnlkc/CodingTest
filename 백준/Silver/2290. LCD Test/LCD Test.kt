fun main() {
    val sb = StringBuilder()
    val (sStr, n) = readln().split(" ")
    val s = sStr.toInt()
    val h = s * 2 + 3

    val map = Array(h) { Array(10) { "" } }

    for (i in 0 until h) {
        for (j in 0 until 10) {
            var str = ""

            when (i) {
                0 -> {
                    if (j == 1 || j == 4) {
                        repeat(s + 2) { str += " " }
                    } else {
                        str += " "
                        repeat(s) { str += "-" }
                        str += " "
                    }
                }
                in 1 until h / 2 -> {
                    if (j == 1 || j == 2 || j == 3 || j == 7) {
                        repeat(s + 1) { str += " " }
                        str += "|"
                    } else if (j == 5 || j == 6) {
                        str += "|"
                        repeat(s + 1) { str += " " }
                    } else {
                        str += "|"
                        repeat(s) { str += " " }
                        str += "|"
                    }
                }
                h / 2 -> {
                    if (j == 1 || j == 7 || j == 0) {
                        repeat(s + 2) { str += " " }
                    } else {
                        str += " "
                        repeat(s) { str += "-" }
                        str += " "
                    }
                }
                in h / 2 + 1 until h - 1 -> {
                    if (j == 1 || j == 3 || j == 4 || j == 5 || j == 7 || j == 9) {
                        repeat(s + 1) { str += " " }
                        str += "|"
                    } else if (j == 2) {
                        str += "|"
                        repeat(s + 1) { str += " " }
                    } else {
                        str += "|"
                        repeat(s) { str += " " }
                        str += "|"
                    }
                }
                else -> {
                    if (j == 1 || j == 4 || j == 7) {
                        repeat(s + 2) { str += " " }
                    } else {
                        str += " "
                        repeat(s) { str += "-" }
                        str += " "
                    }
                }
            }

            map[i][j] = str
        }
    }

    for (i in 0 until h) {
        for (j in n.indices) {
            if (j != 0) sb.append(" ")
            sb.append(map[i][n[j].digitToInt()])
        }

        sb.appendLine()
    }

    print(sb)
}