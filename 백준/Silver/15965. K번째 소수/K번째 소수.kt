fun main() {
    val K = readln().toInt()
    val isPrimeNumber = BooleanArray(10_000_001) { true }
    isPrimeNumber[0] = false
    isPrimeNumber[1] = false

    for (i in 2.. 10_000_000) {
        if (isPrimeNumber[i]) {
            var num = i + i

            while (num < 10_000_000) {
                isPrimeNumber[num] = false
                num += i
            }
        }
    }

    var cnt = 0

    for (i in 2..10_000_000) {
        if (isPrimeNumber[i]) {
            if (++cnt == K) {
                println(i)
                return
            }
        }
    }
}