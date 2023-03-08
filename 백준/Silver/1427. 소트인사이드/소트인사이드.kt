fun main() {
    println(readln().map { it.digitToInt() }.sortedDescending().joinToString(""))
}
