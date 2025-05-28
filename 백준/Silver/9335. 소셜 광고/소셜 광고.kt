val sb = StringBuilder()
var n = 0
var result = Int.MAX_VALUE
var pick = mutableListOf<Int>()
var isFriend = arrayOf<BooleanArray>()

fun main() {
    val tc = readln().toInt()

    for (t in 1..tc) {
        n = readln().toInt()
        result = Int.MAX_VALUE
        isFriend = Array(n + 1) { BooleanArray(n + 1) }
        pick.clear()

        for (i in 1..n) {
            val input = readln().split(" ").map { it.toInt() }

            isFriend[i][i] = true

            for (j in 1..input[0]) {
                isFriend[i][input[j]] = true
                isFriend[input[j]][i] = true
            }
        }

        calc(1)
        sb.appendLine(result)
    }

    print(sb)
}

fun calc(idx: Int) {
    if (pick.size >= result) return

    if (idx == n + 1) {
        val check = BooleanArray(n + 1)

        pick.forEach { num ->
            isFriend[num].forEachIndexed { idx, bool ->
                if (bool) check[idx] = true
            }
        }

        if (check.count { it } == n) result = minOf(result, pick.size)

        return
    }

    calc(idx + 1)
    pick.add(idx)
    calc(idx + 1)
    pick.removeAt(pick.lastIndex)
}