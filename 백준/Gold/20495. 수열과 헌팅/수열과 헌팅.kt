import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()
    val N = readln().toInt()
    val aArr = IntArray(N)
    val bArr = IntArray(N)
    var st: StringTokenizer

    for (i in 0 until N) {
        st = StringTokenizer(readln())
        aArr[i] = st.nextToken().toInt()
        bArr[i] = st.nextToken().toInt()
    }

    val minArr = IntArray(N)
    val maxArr = IntArray(N)

    for (i in 0 until N) {
        minArr[i] = aArr[i] - bArr[i]
        maxArr[i] = aArr[i] + bArr[i]
    }

    minArr.sort()
    maxArr.sort()

    for (i in 0 until N) {
        var minS = 0
        var minE = N - 1
        var min = N - 1

        while (minS <= minE) {
            val mid = (minS + minE) / 2

            if (maxArr[mid] >= aArr[i] - bArr[i]) {
                min = mid
                minE = mid - 1
            } else {
                minS = mid + 1
            }
        }

        var maxS = 0
        var maxE = N - 1
        var max = 0

        while (maxS <= maxE) {
            val mid = (maxS + maxE) / 2

            if (minArr[mid] <= aArr[i] + bArr[i]) {
                max = mid
                maxS = mid + 1
            } else {
                maxE = mid - 1
            }
        }

        sb.appendLine("${min + 1} ${max + 1}")
    }

    print(sb)
}