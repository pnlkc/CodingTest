fun main() {
    val sb = StringBuilder()
    val P = readln().toInt()

    for (tc in 1..P) {
        val arr = readln().split(" ").map { it.toInt() }
        val list = mutableListOf<Int>()
        var cnt = 0

        for (i in 1..20) {
            list.add(arr[i])

            for (j in list.lastIndex - 1 downTo 0) {
                if (list[j + 1] < list[j]) {
                    val temp = list[j + 1]
                    list[j + 1] = list[j]
                    list[j] = temp
                    cnt++
                } else {
                    break
                }
            }
        }

        sb.appendLine("$tc $cnt")
    }

    print(sb)
}