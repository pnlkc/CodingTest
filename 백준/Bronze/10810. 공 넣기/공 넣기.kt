fun main() {
    val input1 = readln().split(" ").map { it.toInt() }
    val array = IntArray(input1[0]) { 0 }
    repeat(input1[1]) {
        val input2 = readln().split(" ").map { it.toInt() }
        for (i in input2[0] - 1 until input2[1]) {
            array[i] = input2[2]
        }
    }
    println(array.joinToString(" "))
}