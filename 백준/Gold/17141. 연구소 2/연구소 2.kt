import java.util.LinkedList
import java.util.StringTokenizer

data class Pos(val x: Int, val y: Int)
data class Data(val x: Int, val y: Int, val c: Int)

var N = 0
var M = 0
var map = arrayOf<IntArray>()
val aL = mutableListOf<Pos>()
val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)
var answer = -1

fun main() {
    var st = StringTokenizer(readln())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    map = Array(N) { IntArray(N) }

    for (i in 0 until N) {
        st = StringTokenizer(readln())

        for (j in 0 until N) {
            map[i][j] = st.nextToken().toInt()

            if (map[i][j] == 2) aL.add(Pos(j, i))
        }
    }

    pick(0, mutableListOf())
    println(if (answer == Int.MAX_VALUE) -1 else answer)
}

fun pick(idx: Int, pL: MutableList<Pos>) {
    if (pL.size == M) {
        bfs(pL)
        return
    }

    if (idx == aL.size) return

    pick(idx + 1, pL)
    val temp = pL.toMutableList()
    temp.add(aL[idx])
    pick(idx + 1, temp)
}

fun bfs(pL: MutableList<Pos>) {
    val temp = Array(N) { IntArray(N) }
    val isVisit = Array(N) { BooleanArray(N) }
    val q = LinkedList<Data>()
    var result = 0

    copy(map, temp)
    for (pos in pL) {
        q.add(Data(pos.x, pos.y, 0))
        isVisit[pos.y][pos.x] = true
        temp[pos.y][pos.x] = 3
    }

    for (i in 0 until N) {
        for (j in 0 until N) {
            if (temp[i][j] == 2) temp[i][j] = 0
        }
    }

    while (q.isNotEmpty()) {
        val c = q.poll()!!

        result = maxOf(result, c.c)

        for (d in 0..3) {
            val nx = c.x + dx[d]
            val ny = c.y + dy[d]

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue
            if (isVisit[ny][nx]) continue
            if (temp[ny][nx] == 1) continue

            q.add(Data(nx, ny, c.c + 1))
            isVisit[ny][nx] = true
            temp[ny][nx] = 3
        }
    }

    if (check(temp)) {
        answer = if (answer == -1) result else minOf(answer, result)
    }
}

fun copy(ori: Array<IntArray>, dest: Array<IntArray>) {
    for (i in 0 until N) {
        for (j in 0 until N) {
            dest[i][j] = ori[i][j]
        }
    }
}

fun check(map: Array<IntArray>): Boolean {
    for (i in 0 until N) {
        for (j in 0 until N) {
            if (map[i][j] == 0) return false
        }
    }

    return true
}