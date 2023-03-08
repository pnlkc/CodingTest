fun main() {
    val testCaseNum = readln().toInt()
    val list = mutableListOf<String>()
    repeat(testCaseNum) {
        list.add(readln())
    }
    list.sortWith(compareBy<String> { it.split(" ")[0].toInt() }.thenBy { it.split(" ")[1].toInt() })
    list.forEach { println(it) }
}