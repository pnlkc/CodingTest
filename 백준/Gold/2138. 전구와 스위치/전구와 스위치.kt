fun main() {
    val N = readln().toInt()
    val init = readln()
    val target = readln()
    val aList = MutableList(N) { 0 }
    val bList = MutableList(N) { 0 }
    val targetList = MutableList(N) { 0 }
    var min = Integer.MAX_VALUE
    var aCnt = 0
    var bCnt = 0

    for (i in 0 until N) {
        aList[i] = init[i].digitToInt()
        bList[i] = init[i].digitToInt()
        targetList[i] = target[i].digitToInt()
    }


    for (i in 0 until N) {
        if (i == 0) {
            bCnt++
            bList[0] = (bList[0] + 1) % 2
            bList[1] = (bList[1] + 1) % 2
        } else {
            if (aList[i - 1] != targetList[i - 1]) {
                aCnt++
                aList[i - 1] = (aList[i - 1] + 1) % 2
                aList[i] = (aList[i] + 1) % 2
                if (i != N - 1) aList[i + 1] = (aList[i + 1] + 1) % 2
            }


            if (bList[i - 1] != targetList[i - 1]) {
                bCnt++
                bList[i - 1] = (bList[i - 1] + 1) % 2
                bList[i] = (bList[i] + 1) % 2
                if (i != N - 1) bList[i + 1] = (bList[i + 1] + 1) % 2
            }

        }
    }

    if (aList.joinToString("") == target) min = minOf(min, aCnt)
    if (bList.joinToString("") == target) min = minOf(min, bCnt)

    println(if (min == Int.MAX_VALUE) -1 else min)
}