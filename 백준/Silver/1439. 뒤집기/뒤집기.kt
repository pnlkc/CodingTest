fun main() {
    val S = readln()
    var zeroCnt = 0
    var oneCnt = 0
    var prev = ' '

    for (i in S.indices) {
        if (S[i] != prev) {
            if (prev == '0') zeroCnt++ else if (prev == '1') oneCnt++

            prev = S[i]
        }
    }

    if (prev == '0') zeroCnt++ else if (prev == '1') oneCnt++

    println(minOf(zeroCnt, oneCnt))
}