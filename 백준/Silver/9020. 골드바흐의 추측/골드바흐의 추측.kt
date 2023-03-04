fun main() {
    val testCaseNum = readln().toInt()
    val list = mutableListOf<Int>()

    for (i in 2..10000) {
        var count = 0
        for (j in 1..i) {
            if (i % j == 0) {
                count++
                if (count > 2) break
            }
        }
        if (count == 2) list.add(i)
    }

    repeat(testCaseNum) {
        val input = readln().toInt()
        val isOk = mutableListOf<Pair<Int, Int>>()
        val filterList = list.filter { it < input }
        
        for (num in filterList) {
            if (filterList.contains(input - num)) {
                isOk.add(minOf(num, input - num) to maxOf(num, input - num))
            }
        }

        isOk.sortBy { it.second - it.first }
        println("${isOk.first().first} ${isOk.first().second}")
    }
}
