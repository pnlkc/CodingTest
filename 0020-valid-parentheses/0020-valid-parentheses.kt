class Solution {
    fun isValid(s: String): Boolean {
        val q = LinkedList<Char>()
        val openArr = charArrayOf('(', '{', '[')
        val map = mutableMapOf(')' to '(', '}' to '{', ']' to '[')

        for (c in s) {
            if (c in openArr) {
                q.addLast(c)
            } else {
                if (q.peekLast() == null || map[c] != q.peekLast()) {
                    return false
                } else {
                    q.pollLast()
                }
            }
        }
        
        return if (q.isNotEmpty()) false else true
    }
}