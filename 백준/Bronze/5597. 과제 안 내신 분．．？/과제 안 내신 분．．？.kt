fun main() {
    val list = (1..30).toMutableList()
    repeat(28) {
        list.remove(readln().toInt())
    }
    list.forEach { println(it) }
}