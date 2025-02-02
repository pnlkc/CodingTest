import java.util.LinkedList

data class Pos(val x: Int, val y: Int)

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val map = Array(M) { Array(N) { "" } }
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)
    val area = Array(M) { IntArray(N) }
    val areaMap = mutableMapOf<Int, Int>()
    var num = 0
    var max = 0

    for (i in 0 until M) {
        val input = readln().split(" ").map {
            var str = it.toInt().toString(2)
            while (str.length < 4) {
                str = "0$str"
            }
            str.reversed()
        }

        for (j in 0 until N) {
            map[i][j] = input[j]
        }
    }
    
    val q = LinkedList<Pos>()
    val isVisit = Array(M) { BooleanArray(N) }

    for (i in 0 until M) {
        for (j in 0 until N) {
            if (isVisit[i][j]) continue

            q.add(Pos(j, i))
            isVisit[i][j] = true
            area[i][j] = ++num
            areaMap[num] = 1

            while (q.isNotEmpty()) {
                val c = q.poll()!!

                for (d in 0..3) {
                    if (map[c.y][c.x][d] == '1') continue

                    val nx = c.x + dx[d]
                    val ny = c.y + dy[d]

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue
                    if (isVisit[ny][nx]) continue

                    q.add(Pos(nx, ny))
                    isVisit[ny][nx] = true
                    area[ny][nx] = num
                    areaMap[num] = areaMap[num]!! + 1
                }
            }
        }
    }

    for (i in 0 until M) {
        for (j in 0 until N) {
            for (d in 0..3) {
                val nx = j + dx[d]
                val ny = i + dy[d]

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue
                if (area[i][j] == area[ny][nx]) continue

                max = maxOf(max, areaMap[area[i][j]]!! + areaMap[area[ny][nx]]!!)
            }
        }
    }

    println(num)
    println(areaMap.values.maxOrNull())
    println(max)
}