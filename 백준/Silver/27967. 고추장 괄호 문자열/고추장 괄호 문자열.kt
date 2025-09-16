fun main() {
    val N = readln().toInt()
    val arr = readln().toCharArray()
    val sCnt = arr.count { it == '(' }
    val needOpen = N / 2 - sCnt
    var gCnt = 0

    for (i in arr.indices) {
        if (arr[i] == 'G') {
            gCnt++
            arr[i] = if (gCnt <= needOpen) '(' else ')'
        }
    }

    println(arr.joinToString(""))
}