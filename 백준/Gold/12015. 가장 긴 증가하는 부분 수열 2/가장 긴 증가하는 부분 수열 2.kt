import java.util.*

fun main() {
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