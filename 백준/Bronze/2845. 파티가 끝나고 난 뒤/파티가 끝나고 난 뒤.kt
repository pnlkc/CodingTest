fun main() {
    val (l, p) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    val result = IntArray(list.size)
    
    for (i in 0 until list.size) {
        result[i] = list[i] - l * p
    }

    println(result.joinToString(" "))
}