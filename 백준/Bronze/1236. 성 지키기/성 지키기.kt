fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { readln() }
    var cntR = 0
    var cntC = 0

    for (i in 0 until n) {
        if ('X' !in map[i]) cntR++
    }

    p@ for (j in 0 until m) {
        for (i in 0 until n) {
            if (map[i][j] == 'X') {
                continue@p
            }
        }
        
        cntC++
    }

    println(maxOf(cntR, cntC))
}