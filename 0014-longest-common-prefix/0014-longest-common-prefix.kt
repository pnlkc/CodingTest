class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var result = ""
        val cnt = strs.minOf { it.length }

        p@ for (i in 0 until cnt) {
            val temp = result + strs[0][i]

            for (j in strs) {
                if (!j.startsWith(temp)) break@p
            }
            
            result = temp
        }

        return result
    }
}