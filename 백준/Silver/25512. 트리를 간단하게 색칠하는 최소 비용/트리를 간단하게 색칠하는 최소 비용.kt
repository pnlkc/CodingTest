import java.util.LinkedList
import kotlin.collections.isNotEmpty

fun main() {
    val n = readln().toInt()
    val map = Array(n) { mutableListOf<Int>() }
    val cost = Array(n) { IntArray(2) }

    for (i in 0 until n - 1) {
        val (p, c) = readln().split(" ").map { it.toInt() }

        map[p].add(c)
        map[c].add(p)
    }

    for (i in 0 until n) {
        val (w, b) = readln().split(" ").map { it.toInt() }

        cost[i][0] = w
        cost[i][1] = b
    }

    val q = LinkedList<Pair<Int, Int>>()
    val isVisit = BooleanArray(n)
    var wResult = cost[0][0].toLong()
    var bResult = cost[0][1].toLong()

    q.add(0 to 0)
    isVisit[0] = true

    while (q.isNotEmpty()) {
        val (cn, cd) = q.poll()!!

        for (next in map[cn]) {
            if (isVisit[next]) continue

            wResult += if ((cd + 1) % 2 == 0) cost[next][0] else cost[next][1]
            isVisit[next] = true
            q.add(next to cd + 1)
        }
    }

    isVisit.fill(false)
    q.add(0 to 0)
    isVisit[0] = true

    while (q.isNotEmpty()) {
        val (cn, cd) = q.poll()!!

        for (next in map[cn]) {
            if (isVisit[next]) continue

            bResult += if ((cd + 1) % 2 != 0) cost[next][0] else cost[next][1]
            isVisit[next] = true
            q.add(next to cd + 1)
        }
    }

    println(minOf(wResult, bResult))
}