fun main() {
    val list = mutableSetOf<Int>()
    repeat(10) {
        list.add(readln().toInt() % 42)
    }
    println(list.size)
}