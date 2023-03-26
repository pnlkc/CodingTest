fun main() {
    val num = readln().toInt()
    val memo = IntArray(num + 1) { Int.MAX_VALUE }
    memo[num] = 0
    calc(memo, num)
    println(memo[1])
}

fun calc(memo: IntArray, num: Int) {
    if (num <= 1) return

    val logic: (Int) -> Unit = { n ->
        if (memo[n] > memo[num] + 1) {
            memo[n] = memo[num] + 1
            calc(memo, n)
        }
    }

    if (num % 3 == 0) logic(num / 3)
    if (num % 2 == 0) logic(num / 2)
    logic(num - 1)
}