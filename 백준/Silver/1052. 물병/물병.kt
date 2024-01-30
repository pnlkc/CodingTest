fun main() {
    var (N, K) = readln().split(" ").map { it.toInt() }
    var result = 0

    while (true) {
        val binary = N.toString(2)
        var cnt = 0

        for (i in binary.indices) {
            if (binary[i] == '1') cnt++
        }

        if (cnt <= K) break

        result++
        N++
    }

    println(result)
}