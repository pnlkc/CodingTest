fun main() {
    val sb = StringBuilder()
    var num = 0

    while (true) {
        num++
        val n = readln().toInt()
        if (n == 0) break

        val nameArr = Array(n + 1) { "" }
        val cntArr = IntArray(n + 1)

        for (i in 1..n) {
            nameArr[i] = readln()
        }

        for (i in 1..(2 * n - 1)) {
            val (num, _) = readln().split(" ")

            cntArr[num.toInt()]++
        }

        for (i in 1..n) {
            if (cntArr[i] == 1) {
                sb.appendLine("$num ${nameArr[i]}")
                break
            }
        }
    }

    println(sb)
}