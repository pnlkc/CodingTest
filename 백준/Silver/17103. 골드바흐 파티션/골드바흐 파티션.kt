fun main() {
    val tcNum = readln().toInt()
    val caseList = mutableListOf<Int>()
    val list = mutableListOf<Int>()
    val map = mutableMapOf<Int, Boolean>()

    repeat(tcNum) {
        caseList.add(readln().toInt())
    }

    p@ for (i in 2..caseList.maxOrNull()!!) {
        for (j in 2..i) {
            if (j * j > i) {
                list.add(i)
                map[i] = true
                continue@p
            }

            if (i % j == 0) continue@p
        }
    }


    for (case in caseList) {
        var result = 0
        for (num in list) {
            if (case / 2 < num) continue
            if (map[case - num] != null) result++
        }
        println(result)
    }
}