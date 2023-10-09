import java.util.StringTokenizer

// Meet In The Middle(MITM, 중간에서 만나기) 알고리즘은 입력크기가 충분히 작을 때
// 완전탐색(브루트포스)을 효율적으로 할 수 있는 알고리즘 입니다.
// 일반적으로 O(2^N)의 시간복잡도를 가지기 때문에 입력크기가 크다면 사용할 수 없습니다.
// ex) 백준 1450번 냅색문제

class MEET_IN_THE_MIDDLE {
    fun mitm() {
        var count = 0
        val (n, c) = readln().split(' ').map(String::toInt)
        val st = StringTokenizer(readln())
        // 1. 주어진 입력 데이터를 두 개의 부분으로 나눕니다.
        val leftArr = IntArray(n / 2) { st.nextToken().toInt() }
        val rightArr = IntArray(n - n / 2) { st.nextToken().toInt() }
        val lResult = calc(leftArr)
        val rResult = calc(rightArr)

        // 3. 나누어진 부분 중 하나를 정렬합니다. (이진 탐색을 하기 위해 정렬합니다.)
        lResult.sort()

        // 4. 두 부분의 처리 결과를 조합하여 최종 결과를 구합니다. (이진 탐색을 통해 조합하였습니다.)
        for (num in rResult) {
            var s = 0
            var e = lResult.lastIndex

            while (s <= e) {
                val mid = (s + e) / 2
                if (lResult[mid] + num <= c) s = mid + 1
                else e = mid - 1
            }

            count += if(lResult[(s + e) / 2] + num <= c) (s + e) / 2 + 1 else 0
        }

        println(count)
    }

    // 2. 나누어진 부분에 대해 가능한 모든 경우를 탐색합니다.
    fun calc(arr: IntArray): MutableList<Int> {
        val list = mutableListOf(0)

        arr.forEach { num ->
            val lastI = list.lastIndex
            for (i in 0..lastI) {
                if (list[i] + num <= 1_000_000_000) list.add(list[i] + num)
            }
        }

        return list
    }
}
