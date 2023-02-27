class Solution {
    fun solution(left: Int, right: Int): Int {
        var answer: Int = 0
        var map = mutableMapOf<Int, Int>()
        
        for (i in left..right) {
            var count = 0
            for (j in 1..i) if (i % j == 0) count++
            map[i] = count
        }
        
        map.forEach {
            if (it.value % 2 == 0) answer += it.key else answer -= it.key
        }
        
        return answer
    }
}