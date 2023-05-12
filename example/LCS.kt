// LCS(Longest Common Subsequence) 알고리즘은 두 수열이 주어졌을 때,
// 두 수열의 부분 수열 중 중 가장 긴 고통 부분 수열을 찾는 문제입니다.
// LCS 알고리즘은 DP 기반의 알고리즘입니다.
// ex) 백준 9251번 LCS
class LCS {
    fun example() {
        val s1 = readln()
        val s2 = readln()
        val memo = Array(s1.length + 1) { IntArray(s2.length + 1) }

        for (i in 1..s1.length) {
            for (j in 1..s2.length) {
                if (s1[i - 1] == s2[j - 1]) memo[i][j] = memo[i - 1][j - 1] + 1
                else memo[i][j] = maxOf(memo[i - 1][j], memo[i][j - 1])
            }
        }

        println(memo[s1.length][s2.length])
    }
}
