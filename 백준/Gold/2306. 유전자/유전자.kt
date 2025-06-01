fun main() {
    val dna = readln()
    val dp = Array(dna.length) { IntArray(dna.length) }

    for (l in dna.indices) {
        for (s in 0..dna.lastIndex - l) {
            val e = s + l

            if ((dna[s] == 'a' && dna[e] == 't') || (dna[s] == 'g' && dna[e] == 'c')) {
                dp[s][e] = maxOf(dp[s][e], dp[s + 1][e - 1] + 2)
            }

            for (k in s until e) {
                dp[s][e] = maxOf(dp[s][e], dp[s][k] + dp[k + 1][e])
            }
        }
    }

    println(dp[0][dna.lastIndex])
}