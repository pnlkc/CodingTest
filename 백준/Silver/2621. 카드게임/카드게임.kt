fun main() {
    val cL = CharArray(5)
    val nL = IntArray(5)

    for (i in 0..4) {
        val (c, n) = readln().split(" ")

        cL[i] = c[0]
        nL[i] = n.toInt()
    }

    cL.sort()
    nL.sort()

    val result = when {
        cL.distinct().size == 1 && nL[4] - 1 == nL[3] && nL[3] - 1 == nL[2] && nL[2] - 1 == nL[1] && nL[1] - 1 == nL[0] -> nL[4] + 900
        nL[0] == nL[3] || nL[1] == nL[4] -> nL[2] + 800
        nL[0] == nL[2] && nL[3] == nL[4] -> nL[0] * 10 + nL[3] + 700
        nL[0] == nL[1] && nL[2] == nL[4] -> nL[2] * 10 + nL[0] + 700
        cL.distinct().size == 1 -> nL[4] + 600
        nL[4] - 1 == nL[3] && nL[3] - 1 == nL[2] && nL[2] - 1 == nL[1] && nL[1] - 1 == nL[0] -> nL[4] + 500
        nL[0] == nL[2] -> nL[0] + 400
        nL[2] == nL[4] -> nL[2] + 400
        nL.distinct().size == 3 -> nL[3] * 10 + nL[1] + 300
        nL.distinct().size == 4 -> nL.filter { n -> nL.count { it == n } == 2 }[0] + 200
        else -> nL[4] + 100
    }

    println(result)
}