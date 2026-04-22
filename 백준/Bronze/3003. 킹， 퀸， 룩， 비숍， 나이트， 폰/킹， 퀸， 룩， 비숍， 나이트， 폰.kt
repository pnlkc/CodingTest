fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val list = intArrayOf(1, 1, 2, 2, 2, 8)
    
    for (i in input.indices) {
        list[i] -= input[i]
    }
    
    println(list.joinToString(" "))
}