class Solution {
    fun solution(str_list: Array<String>): Array<String> {
        for (i in str_list.indices) {
            when (str_list[i]) {
                "l" -> return if (i == 0) arrayOf() else str_list.sliceArray(0 until i)
                "r" -> return if (i == str_list.lastIndex) {
                    arrayOf()
                } else {
                    str_list.sliceArray(i + 1..str_list.lastIndex)
                }
            }
        }
        return arrayOf()
    }
}