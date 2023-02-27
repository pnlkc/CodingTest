class Solution {
    fun solution(a: Int, b: Int): String {
        var answer = ""
        var day = b
        var dayList = arrayOf("THU","FRI","SAT","SUN","MON","TUE","WED")
        
        if (a != 1) {
            for (i in 1..a-1) {
                when (i) {
                    2 -> day += 29
                    1, 3, 5, 7, 8, 10, 12 -> day += 31
                    else -> day += 30
                }
            }
        }
        
        answer = dayList[day%7]
        
        return answer
    }
}