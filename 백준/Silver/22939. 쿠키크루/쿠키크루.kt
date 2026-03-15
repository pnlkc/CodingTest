import kotlin.math.abs

data class Pos(val x: Int, val y: Int)

fun main() {
    val n = readln().toInt()
    val map = Array(n) { CharArray(n) }
    val arr = Array(4) { Array(3) { Pos(0, 0) } }
    val idx = IntArray(4)
    val minArr = IntArray(4) { Int.MAX_VALUE }
    var h = Pos(0, 0)
    var dest = Pos(0, 0)

    for (i in 0 until n) {
        val input = readln()

        for (j in 0 until n) {
            map[i][j] = input[j]

            when (map[i][j]) {
                'J' -> arr[0][idx[0]++] = Pos(j, i)
                'C' -> arr[1][idx[1]++] = Pos(j, i)
                'B' -> arr[2][idx[2]++] = Pos(j, i)
                'W' -> arr[3][idx[3]++] = Pos(j, i)
                'H' -> h = Pos(j, i)
                '#' -> dest = Pos(j, i)
            }
        }
    }

    for (i in 0..2) {
        for (j in 0..2) {
            for (k in 0..2) {
                if (i == j || j == k || i == k) continue

                for (l in 0..3) {
                    val diffA = abs(h.x - arr[l][i].x) + abs(h.y - arr[l][i].y)
                    val diffB = abs(arr[l][i].x - arr[l][j].x) + abs(arr[l][i].y - arr[l][j].y)
                    val diffC = abs(arr[l][j].x - arr[l][k].x) + abs(arr[l][j].y - arr[l][k].y)
                    val diffD = abs(dest.x - arr[l][k].x) + abs(dest.y - arr[l][k].y)

                    minArr[l] = minOf(minArr[l], diffA + diffB + diffC + diffD)
                }
            }
        }
    }

    var min = Int.MAX_VALUE
    var mIdx = 0

    for (i in 0..3) {
        if (minArr[i] < min) {
            mIdx = i
            min = minArr[i]
        }
    }

    println(
        when (mIdx) {
            0 -> "Assassin"
            1 -> "Healer"
            2 -> "Mage"
            else -> "Tanker"
        }
    )
}