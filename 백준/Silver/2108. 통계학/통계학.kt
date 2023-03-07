import kotlin.math.round

fun main() {
    val testCaseNum = readln().toInt()
    val array = IntArray(8001) { 0 }
    val list = mutableListOf<Int>()

    repeat(testCaseNum) {
        val input = readln().toInt()
        array[input + 4000]++
        list.add(input)
    }

    list.sort()

    // 산술평균
    println(round(list.average()).toInt())

    // 중앙값
    println(list[testCaseNum / 2])

    // 최빈값
    val max = array.maxOrNull()!!
    val count = intArrayOf(0, 0)
    for (i in array.indices) {
        if (array[i] == max) {
            count[0]++
            count[1] = i
            if (count[0] == 2) break
        }
    }
    println(count[1] - 4000)

    // 범위
    println(list.last() - list.first())
}