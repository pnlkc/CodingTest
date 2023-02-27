class Solution {
    fun solution(babbling: Array<String>): Int {
        var answer = 0
        for (s in babbling) {
            if (s.contains("ayaaya|yeye|woowoo|mama".toRegex())) continue
            var string = s
            while (string.contains("aya|ye|woo|ma".toRegex())) {
                string = string.replace("aya|ye|woo|ma".toRegex(), " ")
            }
            if (string.isBlank()) answer++
        }
        return answer
    }
}