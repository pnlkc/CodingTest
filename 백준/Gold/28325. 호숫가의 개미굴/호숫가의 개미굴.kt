fun main() {
    val N = readln().toInt()
    val cArr = readln().split(" ").map { it.toLong() }
    val isPickA = BooleanArray(N)
    val isPickB = BooleanArray(N)
    var resultA = 0L
    var resultB = 0L

    for (i in 0 until N) {
        if (cArr[i] != 0L) {
            resultA += cArr[i]
            resultB += cArr[i]
        } else {
            if (i == N - 1) {
                if (!isPickA[i - 1] && !isPickA[0]) {
                    isPickA[N - 1] = true
                    resultA++
                }

                if (!isPickB[i - 1] && !isPickB[0]) {
                    isPickB[N - 1] = true
                    resultB++
                }
            } else {
                if (i == 0 || !isPickA[i - 1]) {
                    isPickA[i] = true
                    resultA++
                }

                if (i != 0  && !isPickB[i - 1]) {
                    isPickB[i] = true
                    resultB++
                }
            }
        }
    }

    println(maxOf(resultA, resultB))
}
