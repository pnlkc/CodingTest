val stringBuilder = StringBuilder()

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    backtracking(n, m, mutableListOf())
    println(stringBuilder.toString())
}

fun backtracking(n: Int, m: Int, usedList: MutableList<Int>) {
    if (usedList.size == m) {
        stringBuilder.append(usedList.joinToString(" ")).append("\n")
        return
    }

    for (i in 1..n) {
        usedList.add(i)
        backtracking(n, m, usedList)
        usedList.removeLast()
    }
}