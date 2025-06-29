fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val arr = Array(N) { IntArray(M + 1) }

    for (i in 0 until N) {
        val input = readln().split(" ").map { it.toInt() }

        if (input[0] == 0 || input[0] == M) {
            println("NO")
            return
        }

        for (j in 0..M) {
            arr[i][j] = input[j]

            if (j > 0) {
                if (arr[i][j] == 1) --arr[i][0]
                else if (arr[i][0] == 0) arr[i][j] = 0
            }
        }
    }

    for (i in 0 until N) {
        for (j in 1..M) {
            if (arr[i][j] != -1) continue
            if (arr[i][0] == 0) {
                if (arr[i][j] == -1) arr[i][j] = 0
                continue
            }

            if (M - j + 1 == arr[i][0]) {
                arr[i][j] = 1
                --arr[i][0]
            } else {
                var hasOne = false

                for (k in 0 until N) {
                    if (arr[k][j] == 1) {
                        hasOne = true
                        break
                    }
                }

                if (!hasOne) {
                    arr[i][j] = 1
                    --arr[i][0]
                }
            }
        }
    }

    for (i in 1..M) {
        var hasOne = false

        for (j in 0 until N) {
            if (arr[j][i] == 1) hasOne = true
        }

        if (!hasOne) {
            println("NO")
            return
        }
    }

    println("YES")
}