fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.sorted()
    
    println((list[n - 1] - list[0]) * 2)
}