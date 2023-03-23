fun main() {
    val size = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val array = IntArray(size) { list[0] }

    for (i in 1 until size) {
        array[i] = maxOf(array[i - 1] + list[i], list[i])
    }

    println(array.maxOrNull()!!)
}