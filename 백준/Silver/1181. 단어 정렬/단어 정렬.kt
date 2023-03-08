fun main() {
    val testCaseNum = readln().toInt()
    val list = mutableSetOf<String>()
    repeat(testCaseNum) {
        list.add(readln())
    }
    list.sortedWith(compareBy<String> { it.length }.thenBy { it }).forEach { println(it) }
}