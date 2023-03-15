fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    backtracking(n, m, mutableListOf())
}

fun backtracking(n: Int, m: Int, usedList: MutableList<Int>) {
    if (usedList.size == m) println(usedList.joinToString(" "))

    for (i in 1..n) {
        if (!usedList.contains(i)) {
            usedList.add(i)
            backtracking(n, m, usedList)
            usedList.remove(i)
        }
    }
}