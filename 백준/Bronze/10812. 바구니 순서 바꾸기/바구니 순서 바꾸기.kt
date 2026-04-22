fun main() {
    val input1 = readln().split(" ").map { it.toInt() }
    var list = List(input1[0]) { it + 1 }

    repeat(input1[1]) {
        val input2 = readln().split(" ").map { it.toInt() - 1 }
        val a = list.slice(0 until input2[0])
        val b = list.slice(input2[2]..input2[1])
        val c = list.slice(input2[0]until input2[2])
        val d = list.slice(input2[1] + 1..list.lastIndex)
        list = a + b + c + d
    }

    println(list.joinToString(" "))
}