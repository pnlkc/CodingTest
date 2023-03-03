fun main() {
    val testCaseNum = readln().toInt()
    repeat(testCaseNum) {
        val k = readln().toInt()
        val n = readln().toInt()
        var array = IntArray(n) { it + 1 }

        repeat(k) {
            val newArray = IntArray(n) { 0 }
            for (i in array.indices) {
                newArray[i] = array[i] + if(i - 1 in array.indices) newArray[i - 1] else 0
            }
            array = newArray
        }

        println(array[n - 1])
    }
}
