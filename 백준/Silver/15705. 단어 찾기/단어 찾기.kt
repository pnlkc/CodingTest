fun main() {
    val s = readln()
    val len = s.length
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { readln().toCharArray() }
    val dx = intArrayOf(1, 1, 1, 0, 0, -1, -1, -1)
    val dy = intArrayOf(1, 0, -1, 1, -1, 1, 0, -1)
    var result = 0

    p@ for (i in 0 until n) {
        for (j in 0 until m) {
            for (d in 0..7) {
                val nx = j + dx[d] * (len - 1)
                val ny = i + dy[d] * (len - 1)

                if (nx !in 0 until m || ny !in 0 until n) continue

                var str = ""

                for (k in 0 until len) {
                    str += map[i + dy[d] * k][j + dx[d] * k]
                }

                if (str == s) {
                    result = 1
                    break@p
                }
            }
        }
    }

    println(result)
}