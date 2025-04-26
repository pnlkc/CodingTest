fun main() {
    val N = readln().toInt()
    val arr = Array(N) { "" }

    for (i in 0 until N) {
        arr[i] = readln()
    }

    val sL = arr.sorted()

    var max = 0
    var sIdx = 0
    var tIdx = 1

    for (i in 0 until sL.lastIndex) {
        for (j in i + 1..sL.lastIndex) {
            if (sL[i][0] != sL[j][0]) break

            var idx = 0

            while (sL[i].length > idx && sL[j].length > idx) {
                if (sL[i][idx] == sL[j][idx]) idx++ else break
            }

            val a = arr.indexOfFirst { it == sL[i] }
            val b = arr.indexOfFirst { it == sL[j] }

            if (max < idx) {
                max = idx
                sIdx = minOf(a, b)
                tIdx = maxOf(a, b)
            } else if (max == idx) {
                if (sIdx > minOf(a, b)) {
                    sIdx = minOf(a, b)
                    tIdx = maxOf(a, b)
                } else if (sIdx == minOf(a, b) && tIdx > maxOf(a, b)) {
                    tIdx = maxOf(a, b)
                }
            } else {
                break
            }
        }
    }

    println(arr[sIdx])
    println(arr[tIdx])
}