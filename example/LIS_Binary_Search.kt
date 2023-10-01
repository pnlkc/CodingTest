import java.util.StringTokenizer

// LIS(Longest Increasing Subsequence) 알고리즘은 가장 긴 증가하는 부분 수열을 찾는 알고리즘입니다
// LIS를 이분 탐색을 통해 푸는 예제입니다
// 시간 복잡도는 O(NlogN)입니다
// ex) 백준 12015번 가장 긴 증가하는 부분 수열2, 3
fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val arr = IntArray(n) { st.nextToken().toInt() }
    val mL = mutableListOf(arr[0]) // 증가하는 부분 수열 계산하기 위한 리스트 (실제 결과와는 다름)
    val record = IntArray(n) // 실제 증가하는 부분 수열을 구하기 위한 배열

    p@ for (i in 1 until n) { // mL에 0번 인덱스 값은 추가했으므로 1부터 시작
        if (arr[i] > mL.last()) { // 현재 숫자가 이전 숫자보다 큰 경우
            mL.add(arr[i])
            record[i]= mL.lastIndex // record 위치의 값 갱신
        } else { // 현재 숫자가 이전 숫자보다 작거나 같은 경우
            var s = 0
            var e = mL.lastIndex

            while (s < e) {
                val mid = (s + e) / 2
                when {
                    mL[mid] == arr[i] -> continue@p  // 현재 숫자와 같은 값의 위치를 찾은 경우
                    mL[mid] > arr[i] -> e = mid // 현재 숫자 보다 큰 값의 위치를 찾은 경우
                    mL[mid] < arr[i] -> s = mid + 1 // 현재 숫자 보다 작은 값의 위치를 찾은 경우
                }
            }

            mL[e] = arr[i] // 해당 위치를 현재 숫자로 변경
            record[i] = e // record 위치의 값 갱신
        }
    }

    val result = mutableListOf<Int>() // 실제 증가하는 부분 수열이 담길 리스트
    var num = mL.lastIndex // 마지막 인덱스

    for (i in n - 1 downTo 0) { // 역순으로 탐색
        if (record[i] == num) {
            result.add(arr[i])
            num--;
        }
    }

    println(mL.size) // 증가하는 부분 수열의 길이
    println(result.reversed()) // 실제 증가하는 부분 수열
}
