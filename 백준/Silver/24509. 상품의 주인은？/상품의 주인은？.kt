data class Data(val score: Int, val num: Int)

fun main() {
    val N = readln().toInt()
    var arr1 = MutableList(N) { Data(0, 0) }
    var arr2 = MutableList(N) { Data(0, 0) }
    var arr3 = MutableList(N) { Data(0, 0) }
    var arr4 = MutableList(N) { Data(0, 0) }

    for (i in 0 until N) {
        val (n, a, b, c, d) = readln().split(" ").map { it.toInt() }

        arr1[i] = Data(a, n)
        arr2[i] = Data(b, n)
        arr3[i] = Data(c, n)
        arr4[i] = Data(d, n)
    }

    val comparator = Comparator<Data> { o1, o2 ->
        when {
            o1.score != o2.score -> o2.score - o1.score
            else -> o1.num - o2.num
        }
    }

    arr1 = arr1.sortedWith(comparator).toMutableList()
    arr2 = arr2.sortedWith(comparator).toMutableList()
    arr3 = arr3.sortedWith(comparator).toMutableList()
    arr4 = arr4.sortedWith(comparator).toMutableList()

    val a = arr1[0].num

    var bIdx = 0
    if (arr1[0].num == arr2[bIdx].num) bIdx++
    val b = arr2[bIdx].num

    var cIdx = 0
    while (arr1[0].num == arr3[cIdx].num || arr2[bIdx].num == arr3[cIdx].num) cIdx++
    val c = arr3[cIdx].num

    var dIdx = 0
    while (arr1[0].num == arr4[dIdx].num || arr2[bIdx].num == arr4[dIdx].num || arr3[cIdx].num == arr4[dIdx].num) dIdx++
    val d = arr4[dIdx].num

    println("$a $b $c $d")
}