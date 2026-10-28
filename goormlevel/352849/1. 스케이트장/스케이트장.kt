fun main() {
    val (W, H, X, Y, P) = readLine()!!.trim().split(" ").map { it.toInt() }
    var cnt = 0
    
    for (p in 1..P) {
        val (x, y) = readLine()!!.trim().split(" ").map { it.toInt() }
        val xD1 = (X - x) * (X - x) * 4
        val yD = (2 * Y + H  - 2 * y) * (2 * Y + H  - 2 * y)
        val xD2 = (X + W - x) * (X + W - x) * 4
        
        if (x in X..(X + W) && y in Y..(Y + H)) cnt++
        else if (xD1 + yD <= H * H) cnt++
        else if (xD2 + yD <= H * H) cnt++
    }
    
    println(cnt)
}