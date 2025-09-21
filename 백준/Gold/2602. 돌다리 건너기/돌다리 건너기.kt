fun main() {
    val str = readln()
    val aL = readln()
    val bL = readln()
    val dpA = Array(str.length + 1) { IntArray(aL.length + 1) }
    val dpB = Array(str.length + 1) { IntArray(bL.length + 1) }
    var result = 0

    for (j in 0 until aL.length) {
        if (aL[j] == str[0]) dpA[1][j] = 1
        if (bL[j] == str[0]) dpB[1][j] = 1
    }

    for (i in 1 until str.length) {
        for (j in 0 until aL.length) {
            if (aL[j] == str[i - 1]) {
                for (k in j + 1 until aL.length) {
                    if (bL[k] == str[i]) dpB[i + 1][k] += dpA[i][j]
                }
            }

            if (bL[j] == str[i - 1]) {
                for (k in j + 1 until bL.length) {
                    if (aL[k] == str[i]) dpA[i + 1][k] += dpB[i][j]
                }
            }
        }
    }

    for (i in 0 until aL.length) {
        result += dpA[str.length][i]
        result += dpB[str.length][i]
    }

    println(result)
}