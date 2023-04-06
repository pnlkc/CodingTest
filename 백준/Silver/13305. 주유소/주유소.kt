import java.util.*

fun main() {
    var r = 0L
    val n = readln().toInt()
    val distToken = StringTokenizer(readln() + " 0")
    val dist = Array(n) { distToken.nextToken().toInt() }
    val costToken = StringTokenizer(readln())
    val cost = Array(n) { costToken.nextToken().toInt() }
    var min = cost[0]

    for (i in cost.indices) {
        min = minOf(min, cost[i])
        r += min * dist[i]
    }

    println(r)
}