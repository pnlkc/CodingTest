class Solution {
    fun solution(word: String): Int {
        var answer = 0
        val wordList = makeList()
        answer = wordList.indexOf(word) + 1
        return answer
    }

    fun makeList(): MutableList<String> {
        val result = mutableListOf<String>()
        val list = listOf("", "A", "E", "I", "O", "U")
        for (i in list) {
            if (i != "") {
                for (j in list) {
                    if (j != "") {
                        for (k in list) {
                            if (k != "") {
                                for (l in list) {
                                    if (l != "") {
                                        for (m in list) {
                                            if (m != "") {
                                                result.add(i + j + k + l + m)
                                            } else {
                                                if (!result.contains(i + j + k + l)) result.add(i + j + k + l)
                                            }
                                        }
                                    } else {
                                        if (!result.contains(i + j + k)) result.add(i + j + k)
                                    }
                                }
                            } else {
                                if (!result.contains(i + j)) result.add(i + j)
                            }
                        }
                    } else {
                        if (!result.contains(i)) result.add(i)
                    }
                }
            }
        }
        return result
    }
}