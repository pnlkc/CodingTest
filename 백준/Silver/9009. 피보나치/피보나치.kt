fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()
    val list = mutableListOf(0, 1)

    while (list.last() < 1_000_000_000) {
        list.add(list[list.lastIndex - 1] + list.last())
    }

    for (tc in 0 until T) {
        var num = readln().toInt()
        val temp = mutableListOf<Int>()
        var idx = list.lastIndex

        while (idx > 0) {
            if (num >= list[idx]) {
                temp.add(list[idx])
                num -= list[idx]
            }

            idx--
        }

       sb.appendLine(temp.reversed().joinToString(" "))
    }

    print(sb)
}