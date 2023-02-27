class Solution {
    var answer = mutableListOf<MutableList<String>>()
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        val resultList = mutableListOf<MutableList<String>>()
        banned_id.forEach { banned ->
            val list = mutableListOf<String>()
            user_id.forEach { user ->
                var result = true
                if (banned.length == user.length) {
                    for (i in banned.indices) {
                        if (banned[i] != '*' && banned[i] != user[i]) {
                            result = false
                            break
                        }
                    }
                    if (result) list.add(user)
                }
            }
            resultList.add(list)
        }
        calc(resultList)
        return answer.size
    }

    fun calc(
        result: MutableList<MutableList<String>>,
        start: Int = 0,
        usedList: MutableList<String> = mutableListOf(),
    ) {
        if (start <= result.lastIndex) {
            for (i in result[start].indices) {
                if (!usedList.contains(result[start][i])) {
                    val temp = usedList.toMutableList()
                    temp.add(result[start][i])
                    temp.sort()
                    calc(result, start + 1, temp)
                }
            }
        } else {
            if (!answer.contains(usedList)) answer.add(usedList)
        }
    }
}