const val limit = 1_000_000

fun main() {
    val sb = StringBuilder()
    val isPrime = BooleanArray(limit + 1) { true }

    initPrimeArr(isPrime)

    var num = readln().toInt()

    while (num != 0) {
        for (i in 3..limit) {
            if (!isPrime[i] || !isPrime[num - i]) continue
            sb.appendLine("$num = $i + ${num - i}")
            break
        }

        num = readln().toInt()
    }

    print(sb)
}

fun initPrimeArr(arr: BooleanArray) {
    for (i in 2..limit) {
        var num = i + i

        while (num <= limit) {
            arr[num] = false
            num += i
        }
    }
}