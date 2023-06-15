import java.util.LinkedList

fun main() {
    val (n, m) = readln().split(' ').map(String::toInt)
    val campus = Array(n) { CharArray(m) }
    var dPos = intArrayOf(-1, -1)

    repeat(n) {
        val row = readln().toCharArray()
        campus[it] = row
        if (dPos.sum() == -2 && row.indexOf('I') != -1) dPos = intArrayOf(it, row.indexOf('I'))
    }

    var answer = 0
    val isVisit = Array(n) { BooleanArray(m) }
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(dPos[0] to dPos[1])
    isVisit[dPos[0]][dPos[1]] = true

    while (queue.isNotEmpty()) {
        val (cy, cx) = queue.poll()!!
        val dx = intArrayOf(1, -1, 0, 0)
        val dy = intArrayOf(0, 0, 1, -1)

        for (i in 0..3) {
            val nx = cx + dx[i]
            val ny = cy + dy[i]

            if (ny >= n || ny < 0 || nx >= m || nx < 0) continue
            if (isVisit[ny][nx] || campus[ny][nx] == 'X') continue

            queue.add(ny to nx)
            isVisit[ny][nx] = true
            if (campus[ny][nx] == 'P') answer++
        }
    }

    println(if (answer == 0) "TT" else answer)
}