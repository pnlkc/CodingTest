class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        var list = intArrayOf()
        var listTwo = arrayListOf<Int>()
        for (i in numbers.indices) {
            if(list.isNotEmpty()) {
                var lastIndex = list.lastIndex
                list.forEach {
                    listTwo.add(it + numbers[i])
                    listTwo.add(it + numbers[i] * -1)
                }
                list = listTwo.toIntArray()
                listTwo.clear()
            } else {
                list = list.plus(numbers[i])
                list = list.plus(numbers[i] * -1)
            }
        }
        answer = list.count { it == target }
        return answer
    }
}