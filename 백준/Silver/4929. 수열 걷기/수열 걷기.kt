import java.util.LinkedList

var aL = listOf<Int>()
var bL = listOf<Int>()
var aMap = mutableMapOf<Int, Int>()
var bMap = mutableMapOf<Int, Int>()
val mL = LinkedList<Int>()

fun main() {
    val sb = StringBuilder()

    while (true) {
        val a = readln()

        if (a == "0") break

        aL = a.split(" ").map { it.toInt() }
        bL = readln().split(" ").map { it.toInt() }
        aMap = mutableMapOf()
        bMap = mutableMapOf()
        mL.clear()

        for (i in 1..aL[0]) {
            aMap[aL[i]] = i
        }

        for (i in 1..bL[0]) {
            bMap[bL[i]] = i

            if (aMap[bL[i]] != null) mL.addLast(bL[i])
        }

        var aIdx = 1
        var bIdx = 1
        var aSum = 0
        var bSum = 0

        while (mL.isNotEmpty()) {
            while (aL[aIdx] != mL.peekFirst()) {
                aSum += aL[aIdx]
                aIdx++
            }

            while (bL[bIdx] != mL.peekFirst()) {
                bSum += bL[bIdx]
                bIdx++
            }

            aSum = maxOf(aSum, bSum)
            bSum = maxOf(aSum, bSum)

            mL.pollFirst()
        }

        while (aIdx <= aL[0]) {
            aSum += aL[aIdx]
            aIdx++
        }

        while (bIdx <= bL[0]) {
            bSum += bL[bIdx]
            bIdx++
        }

        sb.appendLine(maxOf(aSum, bSum))
    }

    print(sb)
}