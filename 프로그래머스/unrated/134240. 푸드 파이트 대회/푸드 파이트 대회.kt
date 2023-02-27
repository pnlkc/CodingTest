class Solution {
    fun solution(food: IntArray): String {
        var string = ""
        for (i in food.indices) {
            repeat (food[i] / 2) {
                string += i
            }
        }
        return string + "0" + string.reversed()
    }
}