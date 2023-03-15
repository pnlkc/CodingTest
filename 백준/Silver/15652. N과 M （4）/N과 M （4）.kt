val stringBuilder = StringBuilder()

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    backtracking(n, m, mutableListOf(), 1)
    println(stringBuilder.toString())
}

fun backtracking(n: Int, m: Int, usedList: MutableList<Int>, min: Int) {
    if (usedList.size == m) {
        stringBuilder.append(usedList.joinToString(" ")).append("\n")
        return
    }

    for (i in min..n) {
        usedList.add(i)
        backtracking(n, m, usedList, i)
        usedList.removeLast()
    }
}