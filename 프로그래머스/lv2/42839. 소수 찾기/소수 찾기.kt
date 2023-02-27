class Solution {
    val resultList = mutableSetOf<Int>()

    fun solution(numbers: String): Int {
        val removeList = mutableSetOf<Int>()

        for (i in 1..numbers.length) {
            addNum(numbers.toCharArray(), i)
        }

        resultList.forEach { num ->
            var result = true
            for (i in 1..num) {
                if (i != 1 && i != num && num % i == 0) {
                    result = false
                    break
                }
            }
            if (!result) removeList.add(num)
        }

        resultList.removeAll(removeList)

        return resultList.size
    }

    fun addNum(
        list: CharArray,
        num: Int,
        string: String = "",
        usedList: MutableList<Int> = mutableListOf(),
    ): String {
        for (i in list.indices) {
            if (num != 1) {
                if (!usedList.contains(i)) {
                    usedList.add(i)
                    addNum(list, num - 1, string + list[i], usedList)
                    usedList.removeAt(usedList.lastIndex)
                }
            } else {
                if (!usedList.contains(i)) {
                    if ((string + list[i]).toInt() != 0 && (string + list[i]).toInt() != 1) {
                        resultList.add((string + list[i]).toInt())
                    }
                }
            }
        }
        return string
    }
}