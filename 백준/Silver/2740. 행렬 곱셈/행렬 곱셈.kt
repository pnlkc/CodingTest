fun main() {
    val (n, m1) = readln().split(" ").map { it.toInt() }
    val a = Array(n) { readln().split(" ").map { it.toInt() } }
    val (m2, k) = readln().split(" ").map { it.toInt() }
    val b = Array(m2) { readln().split(" ").map { it.toInt() } }
    val s = StringBuilder()

    for (x in 0 until n) {
        for (y in 0 until k) {
            var sum = 0
            for (z in 0 until m1) {
                sum += a[x][z] * b[z][y]
            }
            s.append(sum)
            if (y != k - 1) s.append(" ")
        }
        s.append("\n")
    }

    println(s.toString())
}
