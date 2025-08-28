fun main() {
    val N = readln().toInt()
    val target = readln().trim().split(" ").map { it.toInt() }
    val list = IntArray(N)
    var cnt = 0

    for (i in 0 until N) {
        if (list[i] != target[i]) {
            for (j in 0..2) {
                if (i + j >= N) break

                list[i + j] = (list[i + j] + 1) % 2
            }

            cnt++
        }
    }

    println(cnt)
}