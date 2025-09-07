import java.util.LinkedList

data class Data(val t: Int, val cnt: Int)

fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    val input = readln()
    var tCnt = 0

    for (i in 0 until N) {
        if (input[i] == 'T') tCnt++
    }

    val isVisit = BooleanArray(N + 1)
    val q = LinkedList<Data>()

    q.add(Data(tCnt, 0))
    isVisit[tCnt] = true

    while (q.isNotEmpty()) {
        val (cT, cCnt) = q.poll()!!
        val cH = N - cT

        if (cT == N) {
            println(cCnt)
            return
        }

        for (i in 0..K) {
            if (cT < (K - i)) continue
            if (i > cH) break
            
            val nT = cT + i - (K - i)

            if (nT < 0 || nT > N) continue
            if (isVisit[nT]) continue

            q.add(Data(nT, cCnt + 1))
            isVisit[nT] = true
        }
    }

    println(-1)
}