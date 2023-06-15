import java.util.LinkedList

fun main() {
    val n = readln().toInt()
    val arr = Array(n) { charArrayOf() }
    val answer = intArrayOf(0, 0)

    repeat(n) {
        arr[it] = readln().toCharArray()
    }

    val isVisitOne = Array(n) { BooleanArray(n) }
    val isVisitTwo = Array(n) { BooleanArray(n) }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!isVisitOne[i][j]) {
                answer[0]++
                bfs(i, j, arr, isVisitOne, false)
            }

            if (!isVisitTwo[i][j]) {
                answer[1]++
                bfs(i, j, arr, isVisitTwo, true)
            }
        }
    }

    println(answer.joinToString(" "))
}

fun bfs(y: Int, x: Int, arr: Array<CharArray>, isVisit: Array<BooleanArray>, mode: Boolean) {
    val char = arr[y][x]
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(y to x)
    isVisit[y][x] = true

    while (queue.isNotEmpty()) {
        val (cy, cx) = queue.poll()!!

        for (i in 0..3) {
            val nx = cx + dx[i]
            val ny = cy + dy[i]

            if (nx !in arr.indices || ny !in arr.indices) continue
            if (isVisit[ny][nx]) continue


            when{
                mode && (char == 'R' || char == 'G') -> {
                    if (arr[ny][nx] == 'R' || arr[ny][nx] == 'G') {
                        isVisit[ny][nx] = true
                        queue.add(ny to nx)
                    }
                }
                else -> if (arr[ny][nx] == char) {
                    isVisit[ny][nx] = true
                    queue.add(ny to nx)
                }
            }
        }
    }
}