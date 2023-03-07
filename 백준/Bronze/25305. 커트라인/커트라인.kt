fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }.sortedDescending()
    println(list[k - 1])
}