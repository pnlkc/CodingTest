fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val N = readln().toInt()
        val str1 = readln()
        val str2 = readln()
        var d1 = 0
        var d2 = 0

        for (i in 0 until N) {
            if (str1[i] == 'W' && str2[i] == 'B'){
                d1++
            }

            if (str1[i] == 'B' && str2[i] == 'W') {
                d2++
            }
        }

        sb.appendLine(maxOf(d1, d2))
    }

    print(sb)
}