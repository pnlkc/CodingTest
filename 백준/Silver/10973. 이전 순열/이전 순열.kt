fun main() {
    val N = readln().toInt()
    val target = readln().split(" ").map { it.toInt() }.toIntArray()

    println(if (prevPermutation(target))target.joinToString(" ") else -1)
}

fun prevPermutation(arr: IntArray): Boolean {
    var b = arr.lastIndex

    while (b > 0 && arr[b - 1] < arr[b]) {
        b--
    }

    if (b == 0) return false

    val a = b - 1
    var c = arr.lastIndex

    while (arr[a] < arr[c]) {
        c--
    }

    swap(arr, a, c)

    var r = arr.lastIndex

    while (b < r) {
        swap(arr, b++, r--)
    }

    return true
}

fun swap(arr: IntArray, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}