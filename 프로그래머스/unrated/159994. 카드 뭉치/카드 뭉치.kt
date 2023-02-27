class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        val indexArray = intArrayOf(0, 0)
        
        for (i in goal.indices) {
            when (goal[i]) {
                cards1[indexArray[0]] -> if (indexArray[0] + 1 in cards1.indices) indexArray[0]++
                cards2[indexArray[1]] -> if (indexArray[1] + 1 in cards2.indices) indexArray[1]++
                else -> return "No"
            }
        }
        
        return "Yes"
    }
}