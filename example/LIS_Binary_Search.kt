// LIS(Longest Increasing Subsequence) 알고리즘은 가장 긴 증가하는 부분 수열을 찾는 알고리즘입니다.
// LIS를 이분 탐색을 통해 푸는 예제입니다.
// ex) 백준 12015번 가장 긴 증가하는 부분 수열2
class LIS_Binary_Search {
    fun example() {
        val n = readln().toInt()
        val st = StringTokenizer(readln())
        val arr = IntArray(n) { st.nextToken().toInt() }
        val mL = mutableListOf(arr[0])

        p@ for (i in 1 until n) {
            if (arr[i] > mL.last()) mL.add(arr[i])
            else {
                var s = 0
                var e = mL.lastIndex

                while (s < e) {
                    val mid = (s + e) / 2
                    when {
                        mL[mid] == arr[i] -> continue@p
                        mL[mid] > arr[i] -> e = mid
                        mL[mid] < arr[i] -> s = mid + 1
                    }
                }

                mL[e] = arr[i]
            }
        }

        println(mL.size)
    }
}
