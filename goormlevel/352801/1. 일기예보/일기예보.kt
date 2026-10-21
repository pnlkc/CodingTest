fun main() {
    val N = readLine()!!.toInt()
    val list  = readLine()!!.split(" ").map { it.toInt() }
    val (L, R) = readLine()!!.split(" ").map { it.toInt() }
    var cnt = 0
    
    for (i in (L - 1) until R) {
        if (list[i] == 1) cnt++
    }
    
    println(cnt)
}