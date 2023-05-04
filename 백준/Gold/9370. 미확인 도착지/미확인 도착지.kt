import java.util.PriorityQueue

fun main() {
    repeat(readln().toInt()) {
        val (n, m, t) = readln().split(' ').map(String::toInt)
        val (s, g, h) = readln().split(' ').map(String::toInt)
        val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
        var gh = 0

        repeat(m) {
            val (a, b, d) = readln().split(' ').map(String::toInt)
            if ((a == g && b == h) || (a == h && b == g)) gh = d
            graph[a].add(b to d)
            graph[b].add(a to d)
        }

        val list = mutableListOf<Int>()

        repeat(t) {
            list.add(readln().toInt())
        }

        val calcS = calc(s, graph)
        val calcG = calc(g, graph)
        val calcH = calc(h, graph)

        println(
            list
                .filter { e ->
                    val sghe = calcS[g] + gh + calcH[e]
                    val shge = calcS[h] + gh + calcG[e]
                    
                    sghe == calcS[e] || shge == calcS[e]
                }
                .sorted()
                .joinToString(" ")
        )
    }
}

fun calc(s: Int, graph: Array<MutableList<Pair<Int, Int>>>): IntArray {
    val pQ = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    val dist = IntArray(graph.size) { -1 }

    pQ.add(s to 0)
    dist[s] = 0

    while (pQ.isNotEmpty()) {
        val (cn, cd) = pQ.poll()!!

        if (dist[cn] != -1 && dist[cn] < cd) continue

        for ((iN, iD) in graph[cn]) {
            if (dist[iN] == -1 || dist[iN] > dist[cn] + iD) {
                dist[iN] = dist[cn] + iD
                pQ.add(iN to dist[iN])
            }
        }
    }

    return dist
}