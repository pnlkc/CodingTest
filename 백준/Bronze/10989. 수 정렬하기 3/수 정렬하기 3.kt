fun main() {
    val testCaseNum = readln().toInt()
    val array = IntArray(10_001) { 0 }
    repeat(testCaseNum) {
        array[readln().toInt()]++
    }

    array.forEachIndexed { index, i ->
        print("${index}\n".repeat(i))
    }
}