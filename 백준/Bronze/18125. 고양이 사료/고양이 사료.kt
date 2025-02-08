fun main() {
    val (R, C) = readln().split(" ").map { it.toInt() }
    val map = Array(C) { IntArray(R) }
    var result = true

    for (i in 0 until C) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until R) {
            map[i][j] = input[j]
        }
    }

    p@ for (i in 0 until R) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until C) {
            if (map[j][i] != input[C - j - 1]) {
                result = false
                break@p
            }
        }
    }

    println(
        if (!result) {
            """|>___/|     /}
| O O |    / }
( =0= )""${'"'}${'"'}  \
| ^  ____    |
|_|_/    ||__|"""
        } else {
            """|>___/|        /}
| O < |       / }
(==0==)------/ }
| ^  _____    |
|_|_/     ||__|"""
        }
    )
}