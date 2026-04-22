fun main() {
    val input1 = readln().split(" ").map { it.toInt() }
    val array = IntArray(input1[0]) { it + 1 }
    repeat(input1[1]) {
        val input2 = readln().split(" ").map { it.toInt() }
        val num = intArrayOf(array[input2[0] - 1], array[input2[1] - 1])
        array[input2[0] - 1] = num[1]
        array[input2[1] - 1] = num[0]
    }
    println(array.joinToString(" "))
}