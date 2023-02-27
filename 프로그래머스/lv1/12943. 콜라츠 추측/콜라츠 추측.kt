class Solution {
    fun solution(num: Int): Int {
        var answer = 1
        var tool = num.toLong()
        if (num != 1) {
            for (i in 1..500) {
                tool = if (tool % 2 == 0.toLong()) tool / 2 else tool * 3 + 1
                if (tool != 1.toLong()) {
                    answer = -1
                } else {
                    answer = i
                    break
                }
            }
        } else answer = 0
        return answer
    }
}