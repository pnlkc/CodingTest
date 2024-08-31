fun main() {
    val N = readln().toInt()
    val NUM = 1_000_000_007
    val arr = Array(N + 1) { IntArray(N + 1) }
    val cnt = Array(N + 1) { IntArray(N + 1) }
    var result = 0

    arr[0][0] = 1

    for (i in 0 until N) {
        for (j in 0..i) {
            arr[i + 1][j] += arr[i][j]
            arr[i + 1][j] %= NUM
            arr[i + 1][j + 1] = arr[i][j]
            arr[i + 1][j + 1] %= NUM

            if (i == N - 1 && cnt[i][j] % 3 == 1) {
                result += arr[i][j]
                result %= NUM
            }

            cnt[i + 1][j] = makeNum(cnt[i][j] + 1)
        }

        cnt[i + 1][i + 1] = makeNum(cnt[i][i] + 5)
    }

    println(result)
}

fun makeNum(num: Int): Int {
    var n = num
    var result = 0

    while (n > 0) {
        result += n % 10
        n /= 10
    }

    return if (result >= 10) makeNum(result) else result
}