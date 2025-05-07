fun main() {
    val sb = StringBuilder()
    val P = readln().toInt()

    for (tc in 1..P) {
        val arr = readln().split(" ").map { it.toInt() }
        var cnt = 0

        for (i in 2..11) {
            for (j in i..11) {
                if (arr.slice(i..j).count { it <= arr[i - 1] || it <= arr[j + 1] } == 0) cnt++
            }
        }

        sb.appendLine("$tc $cnt")
    }

    print(sb)
}