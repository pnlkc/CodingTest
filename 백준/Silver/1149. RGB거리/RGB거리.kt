fun main() {
    var array = IntArray(3)

    repeat(readln().toInt()) {
        val input = readln().split(" ").map { it.toInt() }
        val one = minOf(array[1] + input[0], array[2] + input[0])
        val two = minOf(array[0] + input[1], array[2] + input[1])
        val three = minOf(array[0] + input[2], array[1] + input[2])
        array = intArrayOf(one, two, three)
    }

    println(array.minOrNull()!!)
}