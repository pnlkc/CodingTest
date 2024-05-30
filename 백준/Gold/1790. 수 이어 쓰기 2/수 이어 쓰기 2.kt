fun Long.length(): Int = this.toString().length

fun main() {
    val (N, k) = readln().split(" ").map { it.toInt() }
    var n = 1L
    var m = k.toLong()
    
    while(m - n * 9 * n.length() > 0) {
        m -= n * 9 * n.length()
        n *= 10
    }

    val num = n + (m - 1) / n.length()

    if (N < num) {
        println(-1)
        return
    }

    println(num.toString()[((m - 1) % n.length()).toInt()])
}