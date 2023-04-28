import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val (m, n) = readln().split(" ").map(String::toInt)
    val queue = LinkedList<Triple<Int, Int, Int>>()
    val arr = Array(n) { IntArray(m) }
    var zero = 0
    var answer = 0

    for (i in 0 until n) {
        val st = StringTokenizer(readln())
        for (j in 0 until m) {
            val c = st.nextToken().toInt()

            arr[i][j] = c

            if (c == 1) queue.add(Triple(i, j, 0))
            else if (c == 0) zero++
        }
    }

    while (queue.isNotEmpty() && zero != 0) {
        val (y, x, r) = queue.poll()!!
        val yR = intArrayOf(1, -1, 0, 0)
        val xR = intArrayOf(0, 0, 1, -1)

        for (i in 0..3) {
            val nx = x + xR[i]
            val ny = y + yR[i]

            if (nx < 0 || nx > m - 1 || ny < 0 || ny > n - 1) continue
            if (arr[ny][nx] == 1 || arr[ny][nx] == -1) continue

            arr[ny][nx] = 1
            queue.add(Triple(ny, nx, r + 1))
            answer = r + 1
            zero--
        }
    }

    println(if (zero > 0) -1 else answer)
}