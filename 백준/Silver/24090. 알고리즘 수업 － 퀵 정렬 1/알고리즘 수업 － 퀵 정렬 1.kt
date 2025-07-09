var cnt = 0
var k = 0

fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }.toIntArray()

    k = K

    quickSort(arr, 0, N - 1)

    if (cnt < k) println(-1)
}

fun quickSort(arr: IntArray, p: Int, r: Int) {
    if (p < r) {
        val q = partition(arr, p, r)

        if (cnt == k) return

        quickSort(arr, p, q - 1)
        quickSort(arr, q + 1, r)
    }
}

fun partition(arr: IntArray, p: Int, r: Int): Int {
    val x = arr[r]
    var i = p - 1

    for (j in p until r) {
        if (arr[j] <= x) {
            val temp = arr[++i]

            arr[i] = arr[j]
            arr[j] = temp

            if (++cnt == k) {
                println("${minOf(arr[i], arr[j])} ${maxOf(arr[i], arr[j])}")
                return -1
            }
        }
    }

    if (i + 1 != r) {
        val temp = arr[i + 1]

        arr[i + 1] = arr[r]
        arr[r] = temp

        if (++cnt == k) {
            println("${minOf(arr[i + 1], arr[r])} ${maxOf(arr[i + 1], arr[r])}")
            return -1
        }
    }

    return i + 1
}