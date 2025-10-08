fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    var sum = 0L
    var max = 0L

    for (i in 0 until N) {
        sum += list[i]
        max = maxOf(max, list[i].toLong())
    }

    println(max + (sum.toDouble() - max) / 2)
}