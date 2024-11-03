fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.sorted()
    val result = mutableListOf<Int>()

    for (i in 0 until n) {
        result.add(list[i] + list[n * 2 - 1 - i])
    }

    println(result.sorted()[0])
}