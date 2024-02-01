var pick = intArrayOf()
var sb = StringBuilder()

fun main() {
    var input = readln()

    while (input != "0") {
        val list = input.split(" ").map { it.toInt() }
        pick = IntArray(6)
        pick(1, 0, list)
        sb.appendLine()
        input = readln()
    }
    
    println(sb)
}

fun pick(idx: Int, cnt: Int, list: List<Int>) {
    if (cnt == 6) {
        sb.appendLine(pick.joinToString(" "))
        return
    }

    if (idx > list.lastIndex) return

    pick[cnt] = list[idx]
    pick(idx + 1, cnt + 1, list)
    pick(idx + 1, cnt, list)
}