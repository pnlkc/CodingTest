class Solution {
    fun solution(my_string: String, queries: Array<IntArray>): String {
        var answer = my_string
        queries.forEach { (s, e) ->
            answer = answer.replaceRange(s..e, answer.slice(s..e).reversed())
        }
        return answer
    }
}