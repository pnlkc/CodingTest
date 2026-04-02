fun main() {
    val n = readln().toInt()
    val aL = readln().split(" ").map { it.toInt() }
    val bL = readln().split(" ").map { it.toInt() }
    var aIdx = 0
    var bIdx = 0
    var aFirst = true
    var result = 0
    val current = intArrayOf(0, 0)

    for (i in 0 until n) {
        val aWin = if ((aL[i] == 1 && bL[i] == 3) || (aL[i] == 2 && bL[i] == 1) || (aL[i] == 3 && bL[i] == 2)) {
            true
        } else if ((aL[i] == 1 && bL[i] == 2) || (aL[i] == 2 && bL[i] == 3) || (aL[i] == 3 && bL[i] == 1)) {
            false
        } else {
            aFirst
        }

        if (aWin) {
            current[1] = 0
            result = maxOf(result, ++current[0])
            bIdx++
            aFirst = false
        } else {
            current[0] = 0
            result = maxOf(result, ++current[1])
            aIdx++
            aFirst = true
        }
    }

    println(result)
}