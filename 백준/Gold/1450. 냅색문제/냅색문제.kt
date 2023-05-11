import java.util.StringTokenizer

fun main() {
    var count = 0
    val (n, c) = readln().split(' ').map(String::toInt)
    val st = StringTokenizer(readln())
    val leftArr = IntArray(n / 2) { st.nextToken().toInt() }
    val rightArr = IntArray(n - n / 2) { st.nextToken().toInt() }
    val lResult = calc(leftArr)
    val rResult = calc(rightArr)

    lResult.sort()

    for (num in rResult) {
        var s = 0
        var e = lResult.lastIndex

        while (s <= e) {
            val mid = (s + e) / 2
            if (lResult[mid] + num <= c) s = mid + 1
            else e = mid - 1
        }

        count += if(lResult[(s + e) / 2] + num <= c) (s + e) / 2 + 1 else 0
    }
    
    println(count)
}

fun calc(arr: IntArray): MutableList<Int> {
    val list = mutableListOf(0)
    arr.forEach { num ->
        val lastI = list.lastIndex
        for (i in 0..lastI) {
            if (list[i] + num <= 1_000_000_000) list.add(list[i] + num)
        }
    }
    return list
}