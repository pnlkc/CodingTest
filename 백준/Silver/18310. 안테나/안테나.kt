fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.sorted()

    println(list[(N -1) / 2])
}