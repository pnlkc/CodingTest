fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    var sum = list[0]
    var result = list[0]
    var min = list[0]

    for (i in 1 until n) {
        result = result.xor(list[i])
        sum += list[i]
        min = minOf(min, list[i])
    }

    println(if (result == 0) sum - min else 0)
}