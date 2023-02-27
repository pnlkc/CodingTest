class Solution {
    fun solution(my_str: String, n: Int): Array<String> {
        val answer = mutableListOf<String>()
        var i = 0
        while (i <= my_str.lastIndex) {
            answer.add(my_str.slice(i until if (i + n > my_str.lastIndex) my_str.length else i + n))
            i += n
        }
        return answer.toTypedArray()
    }
}