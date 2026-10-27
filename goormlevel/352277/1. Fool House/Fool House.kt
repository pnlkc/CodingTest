fun main() {
    val sb = StringBuilder()

    for (tc in 1..readLine()!!.toInt()) {
        val list = readLine()!!.split(" ").map { it.toInt() }.sorted()
        val distinctList = list.distinct()
        val cnt = IntArray(6)
        
        for (num in distinctList) {
            cnt[list.count { it == num }]++
        }
        
        sb.appendLine(if (cnt[4] == 1 || cnt[3] == 1 || cnt[2] == 2) "Yes" else "No")
    }

    print(sb)
}