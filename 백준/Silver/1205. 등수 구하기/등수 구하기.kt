fun main() {
    val (N, newScore, P) = readln().split(" ").map { it.toInt() }

    if (N == 0) {
        println(1)
        return
    }
    
    var rank = readln().split(" ").map { it.toInt() } + newScore
    rank = rank.sortedDescending()
    val list = rank.take(P)
    var result = 0
    var cnt  = 0
    var prev = 0

    for (score in list) {
        cnt++

        if (score != prev) {
            result++
        } else {
            result = cnt
        }

        if (score == newScore) {
            if (rank.size >= P + 1 && rank[P] == newScore) break
            println(result)
            return
        }
    }

    println(-1)
}