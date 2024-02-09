val sb = StringBuilder()

fun main() {
    val N = readln().toInt()

    calc(N, mutableListOf())

    println(sb)
}

fun calc(N: Int, pick: MutableList<Int>) {
    if (pick.size == N) {
        sb.appendLine(pick.joinToString(" "))

        return
    }

    for (i in 1..N) {
        if (pick.contains(i)) continue

        val temp = pick.toMutableList()
        temp.add(i)
        calc(N, temp)
    }
}