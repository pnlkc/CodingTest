fun main() {
    val N = readln().toInt()
    val arr = Array(N) { "" }
    val map = mutableMapOf<String, Int>()

    for (i in 0 until N) {
        arr[i] = readln()
        if (map[arr[i]] == null) map[arr[i]] = i
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

            val a = map[sL[i]]!!
            val b = map[sL[j]]!!

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