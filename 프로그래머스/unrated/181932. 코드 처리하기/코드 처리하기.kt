class Solution {
    fun solution(code: String): String {
        var sb = StringBuilder()
        var mode = false
        
        for (i in code.indices) {
            when {
                !mode && code[i] != '1' -> if (i % 2 == 0) sb.append(code[i])
                !mode && code[i] == '1' -> mode = !mode
                mode && code[i] != '1' -> if (i % 2 == 1) sb.append(code[i])
                mode && code[i] == '1' -> mode = !mode
            }
        }
        
        return if (sb.isEmpty()) "EMPTY" else sb.toString()
    }
}