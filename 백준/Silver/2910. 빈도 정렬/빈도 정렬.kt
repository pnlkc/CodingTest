fun main() {
    val sb = StringBuilder()
    val (N, C) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    val cnt = mutableMapOf<Int, Int>()
    val first = mutableMapOf<Int, Int>()

    for (i in list.indices) {
        if (first[list[i]] == null) first[list[i]] = i
        if (cnt[list[i]] == null) cnt[list[i]] = 1 else cnt[list[i]] = cnt[list[i]]!! + 1
    }

    val cntList = cnt.values.sortedDescending().distinct()

    for (i in cntList.indices) {
        cnt.filter { it.value == cntList[i] }.keys.sortedBy { first[it] }.forEach { num ->
            repeat(cnt[num]!!) { sb.append("$num ") }
        }
    }

    println(sb.trim())
}