fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val MOD = 1_000_000_007

    var all = 1L
    var etc = 1L

    for (i in 1..N) {
        all *= M
        all %= MOD
        etc *= M - 1
        etc %= MOD
    }

    println((all - etc + MOD) % MOD)
}