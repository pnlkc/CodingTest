fun main() {
    val sb = StringBuilder()
    val centiToNano = 10_000_000

    p@ while (true) {
        val x = readlnOrNull()?.toInt() ?: break
        val n = readln().toInt()
        val arr = IntArray(n)

        for (i in 0 until n) {
            arr[i] = readln().toInt()
        }

        arr.sort()

        var s = 0
        var e = n - 1

        while (s < e) {
            when {
                arr[s] + arr[e] < x * centiToNano -> s++
                arr[s] + arr[e] > x * centiToNano -> e--
                arr[s] + arr[e] == x * centiToNano -> {
                    sb.appendLine("yes ${arr[s]} ${arr[e]}")
                    continue@p
                }
            }
        }

        sb.appendLine("danger")
    }

    print(sb)
}