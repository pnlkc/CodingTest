fun main() {
    val sb = StringBuilder()
    val strMap = mutableMapOf(
        "kor" to "100".toInt(4),
        "eng" to "200".toInt(4),
        "math" to "300".toInt(4),
        "apple" to "010".toInt(4),
        "pear" to "020".toInt(4),
        "orange" to "030".toInt(4),
        "red" to "001".toInt(4),
        "blue" to "002".toInt(4),
        "green" to "003".toInt(4),
    )
    val cntMap = mutableMapOf<Int, Int>()
    val (n, m) = readln().split(" ").map { it.toInt() }

    repeat (n) {
        val (s, f, c) = readln().split(" ")
        val num = strMap[s]!! + strMap[f]!! + strMap[c]!!

        cntMap[num] = cntMap.getOrDefault(num, 0) + 1
    }

    repeat (m) {
        val (s, f, c) = readln().split(" ")
        val sr = if (s == "-") 1..3 else strMap[s]!! / 16..strMap[s]!! / 16
        val fr = if (f == "-") 1..3 else strMap[f]!! / 4..strMap[f]!! / 4
        val cr = if (c == "-") 1..3 else strMap[c]!!..strMap[c]!!
        var num = 0

        for (i in sr) {
            for (j in fr) {
                for (k in cr) {
                    num += cntMap.getOrDefault(i * 16 + j * 4 + k, 0)
                }
            }
        }

        sb.appendLine(num)
    }

    print(sb)
}