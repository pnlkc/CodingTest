data class Pos(val x: Int, val y: Int)

val dx = arrayOf(-1, 1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)
val map = Array(5) { IntArray(5) }
val result = mutableMapOf<String, Boolean>()

fun main() {
    for (i in 0 until 5) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until 5) {
            map[i][j] = input[j]
        }
    }

    for (i in 0 until 5) {
        for (j in 0 until 5) {
            move(Pos(j, i), "${map[i][j]}")
        }
    }

    println(result.size)
}

fun move(pos: Pos, num: String) {
    if (num.length < 6) {
        for (d in 0 until 4) {
            val nx = pos.x + dx[d]
            val ny = pos.y + dy[d]

            if (nx < 0 || ny < 0 || nx >= 5  || ny >= 5) continue

            move(Pos(nx, ny), num + map[ny][nx])
        }
    } else {
        result[num] = true
    }
}