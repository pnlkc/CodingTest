// LIS(Longest Increasing Subsequence) 알고리즘은 가장 긴 증가하는 부분 수열을 찾는 알고리즘입니다.
// LIS 알고리즘은 DP를 사용해서 풀 수 있습니다.
// 시간 복잡도는 O(N^2)입니다
// ex) 백준 11053번 가장 긴 증가하는 부분 수열
class LIS_DP {
    fun example() {
        val num = readln().toInt()
        val arr = readln().split(" ").map { it.toInt() }
        val memo = IntArray(num) { 1 }
        var max = 1

        for (i in 1 until num) {
            for (j in 0 until i) {
                if (arr[i] > arr[j]) memo[i] = maxOf(memo[i], memo[j] + 1)
            }
            max = maxOf(max, memo[i])
        }

        println(max)
    }
}
