fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    combination(n, m, mutableListOf(), 1)
}

fun combination(n: Int, m: Int, usedList: MutableList<Int>, start: Int) {
    if (usedList.size == m) {
        println(usedList.joinToString(" "))
        return
    }

    for (i in start..n) {
        if (!usedList.contains(i)) {
            usedList.add(i)
            combination(n, m, usedList, i + 1)
            usedList.removeLast()
        }
    }
}
