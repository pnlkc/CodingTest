import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()

    while (true) {
        val input = readlnOrNull() ?: break
        val N = input.trim().toInt()
        val st = StringTokenizer(readln())
        val arr = IntArray(N)

        for (i in 0 until N) {
            arr[i] = st.nextToken().toInt()
        }

        val mL = mutableListOf(arr[0])
        
        p@ for (i in 1 until N) {
            if (arr[i] > mL.last()) {
                mL.add(arr[i])
            } else {
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

        sb.appendLine(mL.size)
    }

    print(sb)
}