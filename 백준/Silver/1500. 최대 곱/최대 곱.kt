fun main() {
    val (S, K) = readln().split(" ").map { it.toInt() }
    var result = 1L

    for (i in 1..S % K) {
        result *= S / K + 1
    }

    for (i in 1..K - S % K) {
        result *= S / K
    }

    println(result)
}