fun main() {
    val num = readln().toInt()
    val memo = IntArray(num + 1) { 1 }
    for(i in 2..num) {
        memo[i] = (memo[i - 1] + memo[i - 2]) % 15746
    }
    println(memo[num])
}
