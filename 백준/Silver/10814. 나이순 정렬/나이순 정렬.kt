fun main() {
    val testCaseNum = readln().toInt()
    val list = mutableListOf<String>()
    repeat(testCaseNum) {
        list.add(readln())
    }
    list.sortBy { it.split(" ").first().toInt() }
    list.forEach { println(it) }
}