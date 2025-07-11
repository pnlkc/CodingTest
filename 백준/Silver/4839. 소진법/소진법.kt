fun main() {
    val sb = StringBuilder()
    val pArr = intArrayOf(2, 3, 5, 7, 11, 13, 17, 19, 23)
    val nArr = IntArray(9)
    val strArr = Array(9) { "" }

    nArr[0] = 2
    strArr[0] = "2"

    for (i in 1 until 9) {
        nArr[i] = nArr[i - 1] * pArr[i]
        strArr[i] = "${strArr[i - 1]}*${pArr[i]}"
    }

    while (true) {
        val n = readln().toInt()

        if (n == 0) break

        val list = mutableListOf<String>()
        var num = n

        sb.append("$n = ")

        for (i in 8 downTo 0) {
            if (nArr[i] > num) continue
            list.add("${num / nArr[i]}*${strArr[i]}")
            num = num % nArr[i]
        }

        if (num == 1) list.add("1")

        for (i in list.lastIndex downTo 0) {
            sb.append(list[i])
            if (i != 0) sb.append(" + ")
        }


        sb.appendLine()
    }

    print(sb)
}