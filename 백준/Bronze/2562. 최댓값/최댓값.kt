fun main() {
    val list = mutableListOf<Int>()
    repeat(9) {
        list.add(readln().toInt())
    }
    println(list.maxOrNull())
    println(list.indexOf(list.maxOrNull()!!) + 1)
}