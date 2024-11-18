fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.sorted()
    var sum = list.sum()
    var result = 0L

    for (i in 0 until n) {
        sum -= list[i]
        result += sum * list[i]
    }

    println(result)
}