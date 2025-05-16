fun main() {
    val sb = StringBuilder()

    while (true) {
        val N = readlnOrNull()?.toInt() ?: break
        val map = Array(N) { "" }
        val check = IntArray(26)

        for (i in 0 until N) {
            map[i] = readln()
            map[i].forEach { check[it - 'A']++ }
        }

        val max = check.max()
        var x = 0
        var y = 0
        var c = ' '

        if (check.contains(1)) {
            for (i in 0 until 26) {
                if (check[i] == max - 1) c = 'A' + i
            }

            for (i in 0 until N) {
                for (j in 0 until N) {
                    if (check[map[i][j] - 'A'] == 1) {
                        x = j + 1
                        y = i + 1
                    }
                }
            }
        } else {
            for (i in 0 until N) {
                for (j in 0 until N) {
                    val cnt = IntArray(26)

                    for (k in 0 until N) {
                        cnt[map[k][j] - 'A'] ++
                        cnt[map[i][k] - 'A']++
                    }

                    for (k in 0 until 26) {
                        if (cnt[k] == 4) {
                            x = j + 1
                            y = i + 1
                        }

                        if (cnt[k] == 0 && check[k] != 0) {
                            c = 'A' + k
                        }
                    }
                }
            }
        }

        sb.appendLine("$y $x $c")
    }

    print(sb)
}