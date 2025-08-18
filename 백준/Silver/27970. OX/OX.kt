fun main() {
    val str = readln()
    val MOD = 1_000_000_007
    var result = 0L
    var idx = 0
    var num = 1

    for (i in str.indices) {
        if (str[i] == 'O') {
            repeat(i - idx) {
                num *= 2
                num %= MOD
            }

            idx = i
            result += num
            result %= MOD
        }
    }

    println(result)
}