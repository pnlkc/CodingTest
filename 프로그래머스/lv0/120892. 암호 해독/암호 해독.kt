class Solution {
    fun solution(cipher: String, code: Int): String {
        return cipher.filterIndexed { index, _ -> index % code == code - 1 }
    }
}