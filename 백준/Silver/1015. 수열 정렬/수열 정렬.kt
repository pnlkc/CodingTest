fun main() {
    val N = readln().toInt()
    val A = readln().split(" ").map { it.toInt() - 1 }.toMutableList()
    var i = 0

    while (i < N) {
        val fIdx = A.indexOfFirst { it == i }

        if (A.count { it == i } == 0) {
            val min = A.filter { it > i }.min()

            for (j in 0 until N) {
                if (A[j] > i) {
                    A[j] -= min - i
                }
            }
        } else {
            val cnt = A.count { it == i } - 1

            for (j in 0 until N) {
                if (j == fIdx) continue

                if (A[j] >= i) {
                    A[j] += cnt
                }
            }

            i++
        }
    }

    println(A.joinToString(" "))
}