class Solution {
    fun solution(numbers: LongArray): LongArray {
        val answer = mutableListOf<Long>()
        for (number in numbers) { answer.add(calc(number)) }
        return answer.toLongArray()
    }

    fun calc(number: Long): Long {
        var changeNum = number.toString(2)
        val index = changeNum.indexOfLast { it == '0' }
        changeNum = if (index == -1) {
            "1" + changeNum.replaceFirst('1', '0')
        } else {
            if (index != changeNum.lastIndex && changeNum[index + 1] == '1') {
                changeNum.replaceRange(index..index+1, "10")
            } else {
                changeNum.replaceRange(index..index, "1")
            }
        }
        return changeNum.toLong(2)
    }
}