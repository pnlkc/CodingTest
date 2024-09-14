fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    var result = 0

    for (i in 0 until N) {
        var lAngle = list[i].toDouble()
        var lCnt = 0
        for (j in i - 1 downTo 0) {
            val angle = calc(list[j], list[i], i - j)

            if (angle < lAngle) {
                lCnt++
                lAngle = angle
            }
        }

        var rAngle = -list[i].toDouble()
        var rCnt = 0
        for (j in i + 1 until N) {
            val angle = calc(list[i], list[j], j - i)

            if (angle > rAngle) {
                rCnt++
                rAngle = angle
            }
        }

        result = maxOf(result, lCnt + rCnt)
    }

    println(result)
}

fun calc(a: Int, b: Int, dist: Int): Double {
    return (b.toDouble() - a.toDouble()) / dist
}