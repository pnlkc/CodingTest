var result = 9000

fun main() {
    val n = readln().toInt()
    val array = Array(n) { List(n) { 0 } }
    repeat(n) { i ->
        array[i] = readln().split(" ").map { it.toInt() }
    }
    splitTeam(n, 1, 0, mutableListOf(), array)
    println(result)
}

fun splitTeam(n: Int, start: Int, size: Int, aTeam: MutableList<Int>, array: Array<List<Int>>) {
    if (n / 2 == size) {
        val a = calcDiff(aTeam, array)
        val b = calcDiff((1..n) - aTeam.toSet(), array)
        result = minOf(result, if (a - b > 0) a - b else b - a)
        return
    }

    for (i in start..n) {
        if (!aTeam.contains(i)) {
            aTeam.add(i)
            splitTeam(n, i + 1, size + 1, aTeam, array)
            aTeam.removeLast()
        }
    }
}

fun calcDiff(team: List<Int>, array: Array<List<Int>>): Int {
    var diff = 0
    for (i in 0 until team.lastIndex) {
        for (j in i + 1..team.lastIndex) {
            diff += array[team[i] - 1][team[j] - 1]
            diff += array[team[j] - 1][team[i] - 1]
        }
    }
    return diff
}