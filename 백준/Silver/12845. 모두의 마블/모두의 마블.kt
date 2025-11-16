fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.sortedDescending()
    var sum = 0

    for (i in 1 until n) {
        sum += list[0] + list[i]
    }

    println(sum)
}