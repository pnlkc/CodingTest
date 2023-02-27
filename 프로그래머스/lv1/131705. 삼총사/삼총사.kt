class Solution {
    var answer = 0
    fun solution(number: IntArray): Int {
        calc(number, -1, mutableListOf())
        return answer
    }
    
    fun calc(num: IntArray, start: Int, usedList: MutableList<Int>) {
        if (usedList.size == 3) {
            var sum = 0
            usedList.forEach { sum += num[it] }
            if (sum == 0) answer ++
        } else {
            for (i in num.indices) {
                if (i <= start) continue
                val tempList = usedList.toMutableList()
                tempList.add(i)
                calc(num, i, tempList)
            }
        }
    }
}