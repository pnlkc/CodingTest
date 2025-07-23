fun main() {
    val N = readln().toInt()
    val arr = IntArray(N)

    var r = N / 2
    var l = N / 2 - 1

    for (i in N downTo 1 step 2) {
        arr[r++] = i
        if (l >= 0) arr[l--] = i - 1
    }

    println(arr.joinToString(" "))
}