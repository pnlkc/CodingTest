fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }
    var result = Int.MAX_VALUE

    for (i in 1..1000) {
        var cnt = 0
        
        for (j in 0 until N) {
            if (arr[j] != (i + K * j)) cnt++
        }
        
        result = minOf(result, cnt)
    }
    
    println(result)
}