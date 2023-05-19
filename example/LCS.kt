// LCS(Longest Common Subsequence) 알고리즘은 두 수열이 주어졌을 때,
// 두 수열의 부분 수열 중 중 가장 긴 고통 부분 수열을 찾는 문제입니다.
// LCS 알고리즘은 DP 기반의 알고리즘입니다.
// ex) 백준 9251번 LCS / 9252번 LCS 2
class LCS {
    fun example() {
        val s1 = readln()
        val s2 = readln()
        val dp = Array(s1.length + 1) { IntArray(s2.length + 1) }

        // LCS 알고리즘의 핵심입니다.
        for (i in 1..s1.length) {
            for (j in 1..s2.length) {
                if (s1[i - 1] == s2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1
                else dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
            }
        }

        // LCS의 길이는 dp[s1.length][s2.length]의 값이 됩니다.
        println(dp[s1.length][s2.length])


        // 아래는 역추적을 통해 실제 LCS를 구하는 과정입니다.
        // 각 문자열의 끝 인덱스부터 역으로 탐색합니다.
        var i = s1.length
        var j = s2.length
        val sb = StringBuilder()

        // dp[1][1]부터 유효한 값이므로 i, j가 1이상인 경우에만 반복문을 수행합니다.
        while (i > 0 && j > 0) {
            // 만약 s1[i - 1]과  s2[j - 1]이 같은 경우 문자를 추가하고 i, j를 모두 1 감소시킵니다.
            if (s1[i - 1] == s2[j - 1]) {
                sb.append(s1[--i])
                j--
            } else {
                // 만약 s1[i - 1]과  s2[j - 1]이 다른 경우, 
                // dp[i][j]와 dp[i -1][j]의 값이 같다면 i를 1 감소시킵니다.
                // 이외의 경우는 dp[i][j]와 dp[i][j - 1]의 값이 같은 것이므로 j를 1 감소시킵니다.
                if (dp[i][j] == dp[i -1][j]) i-- else j--
            }
        }

        // 생성된 문자열의 길이는 LSC의 길이입니다.
        println(sb.length)
        // LCS는 생성된 문자열을 뒤집은 값입니다.
        println(sb.reverse())
    }
}
