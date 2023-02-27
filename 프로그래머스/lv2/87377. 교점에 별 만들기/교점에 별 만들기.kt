class Solution {
    val crossList = mutableListOf<String>()
    val mList = mutableListOf<Int?>(null, null, null, null)

    fun solution(line: Array<IntArray>): Array<String> {
        calc(line)
        val answer =
            Array(mList[3]!! - mList[2]!! + 1) { CharArray(mList[1]!! - mList[0]!! + 1) { '.' } }
        for (crossString in crossList) {
            val crossPoint = crossString.split(" ").map { it.toInt() }
            answer[mList[3]!! - crossPoint[1]][crossPoint[0] - mList[0]!!] = '*'
        }
        return answer.map { it.joinToString("") }.toTypedArray()
    }

    fun calc(
        line: Array<IntArray>,
        start: Int = 0,
        count: Int = 0,
        usedList: MutableList<Int> = mutableListOf(),
    ) {
        when (count) {
            2 -> {
                val n1 = line[usedList[0]].map { it.toLong() }
                val n2 = line[usedList[1]].map { it.toLong() }
                val down = n1[0] * n2[1] - n1[1] * n2[0]
                val xUp = n1[1] * n2[2] - n1[2] * n2[1]
                val yUp = n1[2] * n2[0] - n1[0] * n2[2]

                if (down != 0L && xUp % down == 0L && yUp % down == 0L) {
                    val x = (xUp / down).toInt()
                    val y = (yUp / down).toInt()

                    if (!crossList.contains("$x $y")) crossList.add("$x $y")

                    if (mList[0] == null) {
                        mList[0] = x
                        mList[1] = x
                    } else {
                        when {
                            x > mList[1]!! -> mList[1] = x
                            x < mList[0]!! -> mList[0] = x
                        }
                    }

                    if (mList[2] == null) {
                        mList[2] = y
                        mList[3] = y
                    } else {
                        when {
                            y > mList[3]!! -> mList[3] = y
                            y < mList[2]!! -> mList[2] = y
                        }
                    }
                }
            }
            else -> {
                for (i in start until line.lastIndex + count) {
                    val temp = usedList + i
                    calc(line, start + 1, count + 1, temp.toMutableList())
                }
            }
        }
    }
}