fun main() {
    val array = IntArray(readln().toInt()) { readln().toInt() }
    println(array.sorted().joinToString("\n"))
}