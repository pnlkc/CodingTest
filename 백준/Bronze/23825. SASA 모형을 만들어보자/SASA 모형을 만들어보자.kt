fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    
    println(minOf(n, m) / 2)
}