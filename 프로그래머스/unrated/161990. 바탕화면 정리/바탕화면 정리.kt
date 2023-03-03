class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
        val answer = intArrayOf(wallpaper.lastIndex, wallpaper[0].lastIndex, 0, 0)
        for (i in wallpaper.indices) {
            for (j in wallpaper[0].indices) {
                if (wallpaper[i][j] == '#') {
                    if (answer[0] > i) answer[0] = i
                    if (answer[1] > j) answer[1] = j
                    if (answer[2] < i + 1) answer[2] = i + 1
                    if (answer[3] < j + 1) answer[3] = j + 1
                }
            }
        }
        return answer
    }
}