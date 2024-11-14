fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    p@for (tc in 1..T) {
        val k = readln().toInt()
        val arr = Array(k) { "" }

        for (i in 0 until k) {
            arr[i] = readln()
        }

        for (i in 0 until k) {
            for (j in 0 until k) {
                if (i == j) continue

                val str = arr[i] + arr[j]

                if (str == str.reversed()) {
                    sb.appendLine(str)
                    continue@p
                }
            }
        }

        sb.appendLine(0)
    }

    print(sb)
}