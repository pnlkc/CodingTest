class Solution {
    fun solution(strArr: Array<String>): Array<String> {
        return strArr.mapIndexed { idx, s -> 
            if (idx % 2 == 0) s.lowercase() else s.uppercase()
        }.toTypedArray()
    }
}