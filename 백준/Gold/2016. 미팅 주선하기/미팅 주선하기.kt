var arr = Array(10) { IntArray(5) }
var rank = Array(10) { IntArray(10) }

fun main() {
    val T = readln().toInt()

    t@ for (t in 1..T) {
        arr = Array(10) { IntArray(5) }
        rank = Array(10) { IntArray(10) }

        for (i in 0..4) {
            arr[0][i] = i + 5
            rank[0][i + 5] = i
        }

        for (i in 1..9) {
            val input = readln().split(" ").map { it.toInt() - 1 }

            for (j in 0..4) {
                arr[i][j] = input[j]
                rank[i][input[j]] = j
            }
        }

        val num = calc()

        p@ for (a in 5..9) {
            for (b in 5..9) {
                for (c in 5..9) {
                    for (d in 5..9) {
                        for (e in 5..9) {
                            if (a == b || a == c || a == d || a == e || b == c || b == d || b == e || c == d || c == e || d == e) continue

                            arr[0][0] = a
                            arr[0][1] = b
                            arr[0][2] = c
                            arr[0][3] = d
                            arr[0][4] = e
                            rank[0][a] = 0
                            rank[0][b] = 1
                            rank[0][c] = 2
                            rank[0][d] = 3
                            rank[0][e] = 4

                            if (calc() < num) {
                                println("YES")
                                continue@t
                            }
                        }
                    }
                }
            }
        }

        println("NO")
    }
}

fun calc(): Int {
    val check = IntArray(10) { -1 }

    while (check.contains(-1)) {
        p@ for (i in 5..9) {
            if (check[i] != -1) continue

            for (j in 0..4) {
                if (check[arr[i][j]] == -1) {
                    check[arr[i][j]] = i
                    check[i] = arr[i][j]
                    continue@p
                } else {
                    if (rank[arr[i][j]][check[arr[i][j]]] > rank[arr[i][j]][i]) {
                        check[check[arr[i][j]]] = -1
                        check[arr[i][j]] = i
                        check[i] = arr[i][j]
                        continue@p
                    }
                }
            }
        }
    }

    return check[0]
}