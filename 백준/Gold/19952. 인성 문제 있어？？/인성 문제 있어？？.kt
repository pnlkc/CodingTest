import java.util.LinkedList

data class Data(val x: Int, val y: Int, val p: Int)

fun main() {
    val T = readln().toInt()
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    p@ for (tc in 1..T) {
        val list = readln().split(" ").map { it.toInt() }
        val h = list[0]
        val w = list[1]
        val o = list[2]
        val f = list[3]
        val xs = list[4] - 1
        val ys = list[5] - 1
        val xe = list[6] - 1
        val ye = list[7] - 1
        val map = Array(h) { IntArray(w) }
        val q = LinkedList<Data>()
        val isVisit = Array(h) { IntArray(w) { -1 } }

        for (i in 0 until o) {
            val (x, y, l) = readln().split(" ").map { it.toInt() }

            map[x - 1][y - 1] = l
        }

        q.add(Data(ys, xs, f))
        isVisit[xs][ys] = f
        
        while (q.isNotEmpty()) {
            val (cx, cy, cp) = q.poll()!!

            if (cx == ye && cy == xe) {
                println("잘했어!!")
                continue@p
            }

            if (cp < 0) continue

            for (d in 0..3) {
                val nx = cx + dx[d]
                val ny = cy + dy[d]

                if (nx < 0 || nx >= w || ny < 0 || ny >= h) continue
                if (map[cy][cx] < map[ny][nx] && map[ny][nx] - map[cy][cx] > cp) continue

                if (isVisit[ny][nx] >= cp - 1) continue

                q.add(Data(nx, ny, cp - 1))
                isVisit[ny][nx] = cp - 1
            }
        }

        println("인성 문제있어??")
    }
}