class Solution {
    fun solution(my_string: String): Array<String> {
        val answer = mutableListOf<String>()
        var s = my_string
        while (s.isNotEmpty()) {
            answer.add(s)
            s = s.drop(1)
        }
        return answer.sorted().toTypedArray()
    }
}