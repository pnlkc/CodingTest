fun main() {
    val S = readln()
    val P = readln()

    var idx = 0
    var result = 0

    while (idx < P.length) {
        var i = 0
        var cnt = 0

        while (i < S.length) {
            for (j in i..S.lastIndex) {
                if (idx + j - i >= P.length || P[idx + j - i] != S[j]) break

                cnt = maxOf(cnt, j - i + 1)
            }

            i++
        }

        idx += cnt
        result++
    }

    println(result)
}