fun main() {
    val num = readln().toInt()
    val arr = IntArray(num) { readln().toInt() }
    val memo = IntArray(num)
    memo[0] = arr[0]

    for (i in 1 until num) {
        memo[i] = maxOf(
            arr[i] + if (i > 1) memo[i - 2] else 0,
            arr[i] + arr[i - 1] + if(i > 2) memo[i - 3] else 0,
            if (i > 3) arr[i] + arr[i - 1] + memo[i - 4] else 0
        )
    }

    println(memo.maxOrNull()!!)
}