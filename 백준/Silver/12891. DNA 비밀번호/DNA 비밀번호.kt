fun main() {
    val (S, P) = readln().split(" ").map { it.toInt() }
    val str = readln()
    val (A, C, G, T) = readln().split(" ").map { it.toInt() }
    val cnt = mutableMapOf<Char, Int>(
        'A' to 0, 'C' to 0, 'G' to 0, 'T' to 0
    )
    var result = 0

    for (i in 0..(S - P)) {
        if (i == 0) {
            for (j in 0 until 0 + P) {
                cnt[str[j]] = cnt[str[j]]!! + 1
            }

            if (cnt['A']!! >= A && cnt['C']!! >= C && cnt['G']!! >= G && cnt['T']!! >= T) result++
        } else {
            cnt[str[i - 1]] = cnt[str[i - 1]]!! - 1
            cnt[str[i + P - 1]] = cnt[str[i + P - 1]]!! + 1

            if (cnt['A']!! >= A && cnt['C']!! >= C && cnt['G']!! >= G && cnt['T']!! >= T) result++
        }
    }

    println(result)
}