fun main() {
    val input1 = readln().split(" ").map { it.toInt() }
    var list = List(input1[0]) { it + 1 }

    repeat(input1[1]) {
        val input2 = readln().split(" ").map { it.toInt() }
        list = list.slice(0 until input2[0] - 1) + list.slice(input2[0] - 1 until input2[1]).reversed() + list.slice(input2[1]..list.lastIndex)
    }
    
    println(list.joinToString(" "))
}