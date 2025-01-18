fun main() {
    val S = readln()
    val sL = S.length
    val iL = IntArray(300_001) { -1 }
    val cnt = Array(2) { IntArray(sL + 1) }
    var result = -1

    for (i in 0 until sL) {
        cnt[0][i + 1] = cnt[0][i]
        cnt[1][i + 1] = cnt[1][i]

        if (S[i] == 'S') cnt[0][i + 1] += 2
        if (S[i] == 'K') cnt[1][i + 1]++
    }

    for (i in 0..sL) {
        val idx = cnt[0][i] - cnt[1][i] + 100_000

        if (iL[idx] == -1) {
            iL[idx] = i
        } else {
            if (cnt[0][iL[idx]] == cnt[0][i] && cnt[1][iL[idx]] == cnt[1][i]) continue
            result = maxOf(result, i - iL[idx])
        }
    }

    println(result)
}
