var n = 0
var m = 0
var map = arrayOf<BooleanArray>()
var sticker = arrayOf<IntArray>()

fun main() {
    val (N, M, K) = readln().split(" ").map { it.toInt() }
    var result = 0

    map = Array(N) { BooleanArray(M) }
    n = N
    m = M

    for (s in 0 until K) {
        val (R, C) = readln().split(" ").map { it.toInt() }
        sticker = Array(R) { IntArray(C) }

        for (i in 0 until R) {
            val input = readln().split(" ").map { it.toInt() }

            for (j in 0 until C) {
                sticker[i][j] = input[j]
            }
        }

        if (!check(R, C)) {
            for (i in 0..2) {
                rotate(sticker.size, sticker[0].size)
                if (check(sticker.size, sticker[0].size)) break
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j]) result++
        }
    }

    println(result)
}

fun check(r: Int, c:Int): Boolean {
    for (i in 0 until  n) {
        p@for (j in 0 until m) {
            val temp = Array(n) { map[it].clone() }

            for (k in 0 until r) {
                for (l in 0 until c) {
                    if (i + k >= n || j + l >= m) continue@p
                    if (sticker[k][l] == 0) continue
                    if (map[i + k][j + l]) continue@p

                    temp[i + k][j + l] = true
                }
            }

            map = temp

            return true
        }
    }

    return false
}

fun rotate(r: Int, c: Int) {
    val temp = Array(c) { IntArray(r) }

    for (i in 0 until r) {
        for (j in 0 until c) {
            temp[j][r - i - 1] = sticker[i][j]
        }
    }

    sticker = temp
}