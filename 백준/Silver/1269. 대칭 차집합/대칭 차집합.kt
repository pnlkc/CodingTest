fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val nList = readln().split(" ").map { it.toInt() }
    val mList = readln().split(" ").map { it.toInt() }
    println((nList + mList).distinct().size * 2 - n - m)
}