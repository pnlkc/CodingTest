import java.util.StringTokenizer

// 투 포인터 알고리즘은 배열이나 리스트와 같은 선형 자료구조에서
// 두 개의 포인터를 이용하여 문제를 해결하는 알고리즘입니다.
// 투 포인터 알고리즘은 부분 합, 부분 문자열, 특정 조건을 만족하는 항목 찾기에 사용됩니다.
// 일반적으로 O(n)의 시간복잡도가 걸리며, 한 번의 순회로 문제를 해결할 수 있습니다.
// ex) 백준 1806번 부분합
class Two_Pointer {
    fun twoPointer() {
        val (n, s) = readln().split(' ').map(String::toInt)
        val st = StringTokenizer(readln())
        val list = List(n) { st.nextToken().toInt() }
        var min = Int.MAX_VALUE
        var sum = 0
        // 시작점 설정
        var l = 0
        // 끝점 설정 (끝점이 list의 마지막 요소에서 시작하는 문제들도 존재합니다)
        var r = 0

        // 시작점이 list의 마지막 인덱스가 될 때 까지 탐색합니다.
        while (l < n) {
            // sum의 값의 변화에 따라 시작점이나 끝점의 값을 변경합니다.
            if (sum < s && r < n) sum += list[r++]
            else sum -= list[l++]

            // 문제의 조건에 부합하는 경우 별도의 처리를 합니다.
            if (sum >= s) min = minOf(min, r - l)
        }

        println(if (min == Int.MAX_VALUE) 0 else min)
    }
}
