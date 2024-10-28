data class Pos(val x: Int, val y: Int)

val map = Array(5) { CharArray(9) }
val isUsed = BooleanArray(12)
val dx = intArrayOf(1, 1, 1, 0, 0, -1, -1, -1)
val dy = intArrayOf(1, 0, -1, 1, -1, 1, 0, -1)
var result = false
val list = mutableListOf<Pos>()

fun main() {
    for (i in 0..4) {
        val input = readln()

        for (j in 0..8) {
            map[i][j] = input[j]
            if (map[i][j] == 'x') list.add(Pos(j, i))
            if (map[i][j] in 'A'..'L') {
                isUsed[map[i][j].code - 'A'.code] = true
            }
        }
    }

    calc(0)
}

fun calc(idx: Int) {
    if (result) return
    if (idx == list.size) {
        if (checkSum()) {
            for (i in 0 until 5) {
                println(map[i].joinToString(""))
            }
            result = true
        }
        return
    }

    val x = list[idx].x
    val y = list[idx].y

    for (k in 0..11) {
        if (isUsed[k]) continue
        map[y][x] = (k + 'A'.code).toChar()
        isUsed[k] = true
        calc(idx + 1)
        isUsed[k] = false
    }
}

fun checkSum() : Boolean {
    for (i in 0..4) {
        for (j in 0..8) {
            if (map[i][j] != '.') {
                for (d in 0..7) {
                    var sum = 0
                    var cnt = 0

                    for (k in 0..8) {
                        val nx = j + dx[d] * k
                        val ny = i + dy[d] * k

                        if (nx < 0 || ny < 0 || nx >= 9 || ny >= 5) continue
                        if (map[ny][nx] == '.') continue

                        sum += map[ny][nx].code - 'A'.code + 1
                        cnt++
                    }

                    if (cnt == 4 && sum != 26) return false
                }
            }
        }
    }

    return true
}