fun main() {
    val (r, c) = readln().trim().split(" ").map { it.toInt() }
    val map = Array(r) { IntArray(c) }

    for (i in 0 until r) {
        val input = readln().trim().split(" ").map { it.toInt() }

        for (j in 0 until c) {
            map[i][j] = input[j]
        }
    }
    
    val t = readln().trim().toInt()
    val result = Array(r - 2) { IntArray(c - 2) }
    var cnt = 0
    
    for (i in 0 until r - 2) {
        for (j in 0 until c - 2) {
            val list = IntArray(9)
            
            for (k in 0..2) {
                for (l in 0..2) {
                    list[k * 3 + l] = map[i + k][j + l]
                }
            }
            
            list.sort()
            result[i][j] = list[4]
            if (result[i][j] >= t) cnt++
        }
    }
    
    println(cnt)
}