import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val arr = IntArray(n) { st.nextToken().toInt() }
    val mL = mutableListOf(arr[0])
    val idxArr = IntArray(n)

    p@ for (i in 1 until n) {
        if (arr[i] > mL.last()) {
            mL.add(arr[i])
            idxArr[i] = mL.lastIndex
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
            idxArr[i] = e
        }
    }

    println(mL.size)

    val lis = IntArray(mL.size)
    var num = mL.size - 1
    for (i in idxArr.lastIndex downTo 0) {
        if (idxArr[i] == num) lis[num--] = arr[i]
    }

    println(lis.joinToString(" "))
}