import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val (m, n, h) = readln().split(" ").map(String::toInt)
    val queue = LinkedList<IntArray>()
    val arr = Array(h) { Array(n) { IntArray(m) } }
    var zero = 0
    var answer = 0

    for (z in 0 until h) {
        for (y in 0 until n) {
            val st = StringTokenizer(readln())

            for (x in 0 until m) {
                val ct = st.nextToken().toInt()

                arr[z][y][x] = ct

                if (ct == 1) queue.add(intArrayOf(z, y, x, 0))
                else if (ct == 0) zero++
            }
        }
    }

    while (queue.isNotEmpty() && zero != 0) {
        val c = queue.poll()!!
        val yR = intArrayOf(1, -1, 0, 0, 0, 0)
        val xR = intArrayOf(0, 0, 1, -1, 0, 0)
        val zR = intArrayOf(0, 0, 0, 0, 1, -1)

        for (i in 0..5) {
            val ny = c[1] + yR[i]
            val nx = c[2] + xR[i]
            val nz = c[0] + zR[i]

            if (nx < 0 || nx > m - 1 || ny < 0 || ny > n - 1 || nz < 0 || nz > h - 1) continue
            if (arr[nz][ny][nx] == 1 || arr[nz][ny][nx] == -1) continue

            arr[nz][ny][nx] = 1
            queue.add(intArrayOf(nz, ny, nx, c[3] + 1))
            answer = c[3] + 1
            zero--
        }
    }

    println(if (zero > 0) -1 else answer)
}