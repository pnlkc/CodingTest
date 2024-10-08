data class Pos(val x: Int, val y: Int)

fun main() {
    val N = readln().toInt()
    val map = Array(N) { CharArray(N) }
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)
    var cnt = intArrayOf(0, 0, 0, 0, 0)

    for (i in 0 until N) {
        val input = readln()

        for (j in 0 until N) {
            map[i][j] = input[j]
        }
    }

    var heart = Pos(-1, -1)

    p@for (i in 0 until N) {
        q@ for (j in 0 until N) {
            if (map[i][j] == '*') {
                for (d in 0..3) {
                    val nx = j + dx[d]
                    val ny = i + dy[d]

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue
                    if (map[ny][nx] == '_') continue@q
                }

                heart = Pos(j, i)
                break@p
            }
        }
    }

    // 왼쪽 팔
    var x1 = heart.x - 1
    while (x1 >= 0) {
        if (map[heart.y][x1--] == '*') cnt[0]++
    }

    // 오른쪽 팔
    var x2 = heart.x + 1
    while (x2 < N) {
        if (map[heart.y][x2++] == '*') cnt[1]++
    }

    // 허리
    var y1 = heart.y + 1
    while (y1 < N) {
        if (map[y1++][heart.x] == '*') cnt[2]++
        else break
    }

    val mid = Pos(heart.x, y1 - 1)

    // 왼쪽 다리
    var y2 = mid.y
    while (y2 < N) {
        if (map[y2++][heart.x - 1] == '*') cnt[3]++
    }

    // 오른쪽 다리
    var y3 = mid.y
    while (y3 < N) {
        if (map[y3++][heart.x + 1] == '*') cnt[4]++
    }

    println("${heart.y + 1} ${heart.x + 1}")
    println(cnt.joinToString(" "))
}