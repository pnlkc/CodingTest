fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()
    val pArr = BooleanArray(1_001) { true }
    val pL = mutableListOf<Int>()

    for (i in 2..1000) {
        var num = i + i

        while (num <= 1000) {
            pArr[num] = false
            num += i
        }
    }

    for (i in 2..1000) {
        if (pArr[i]) pL.add(i)
    }

    p@for (tc in 0 until T) {
        val num = readln().toInt()

        for (i in 0..pL.lastIndex) {
            for (j in i..pL.lastIndex) {
                for (k in j..pL.lastIndex) {
                    if (pL[i] + pL[j] + pL[k] == num) {
                        sb.appendLine("${pL[i]} ${pL[j]} ${pL[k]}")
                        continue@p
                    }
                }
            }
        }

        sb.appendLine(0)
    }

    print(sb)
}