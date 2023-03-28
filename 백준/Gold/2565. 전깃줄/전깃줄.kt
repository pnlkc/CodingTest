/**
 * 전깃줄 문제의 핵심은 전깃줄이 서로 겹치지 않으려면 A, B 기둥의 번호가 모두 커야 한다는 것이다.
 * 동적 계획법 알고리즘의 LIS(Longest Increasing Subsequence)를 사용해 문제를 풀면 된다.
 */

fun main() {
    val tcNum = readln().toInt()
    val arr = Array(tcNum) { readln().split(" ").map { it.toInt() }.toIntArray() + intArrayOf(1) }

    // 왼쪽 기둥 번호를 기준으로 오름차순 정렬
    arr.sortBy { it[0] }

    for (n in 1 until tcNum) {
        arr[n][2] += arr
            .filterIndexed { i, ints -> i <= n && ints[0] < arr[n][0] && ints[1] < arr[n][1] }
            .maxOfOrNull { it[2] } ?: 0
    }

    println(tcNum - arr.maxOf { it[2] })
}
