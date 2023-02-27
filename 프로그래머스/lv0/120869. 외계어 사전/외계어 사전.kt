class Solution {
    fun solution(spell: Array<String>, dic: Array<String>): Int {
        p@for (d in dic) {
            for (s in spell) {
                if (d.count { it.toString() == s } != 1) continue@p
            }
            return 1
        }
        return 2
    }
}