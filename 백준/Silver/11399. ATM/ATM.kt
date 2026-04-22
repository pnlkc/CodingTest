fun main() {
    val n = readln().toInt()
    var c = 0
    println(readln().split(" ").map { it.toInt() }.sorted()
        .fold(0) { acc, i -> (acc + i + c).also { c += i } })
}