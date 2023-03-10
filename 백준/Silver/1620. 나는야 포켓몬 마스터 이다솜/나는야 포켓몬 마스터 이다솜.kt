fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val nameMap = mutableMapOf<String, Int>()
    val nList = mutableListOf<String>()
    for (i in 1..n) {
        val input = readln()
        nameMap[input] = i
        nList.add(input)
    }
    repeat(m) {
        val input = readln()
        println(if (input.toIntOrNull() != null) nList[input.toInt() - 1] else nameMap[input])
    }
}