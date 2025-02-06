fun main() {
    val (a, b) = readln().split(" ").map { it.toLong() }
    var cnt = 0L
    var n = 1L

    while (n * n <= a) {
        n++
    }

    while (n * n <= b) {
        n++
        cnt++
    }

    val gcd = gcd(b - a, cnt)
    
    println(  if (cnt == 0L) 0 else "${cnt / gcd}/${(b - a) / gcd}")
}

fun gcd(a: Long, b: Long): Long {
    return if (b != 0L) gcd(b, a % b) else a
}