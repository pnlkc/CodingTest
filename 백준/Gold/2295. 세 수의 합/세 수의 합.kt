fun main() {
    val N = readln().toInt()
    val arr = IntArray(N)
    val map = mutableMapOf<Int, Byte>()
    var r = 0

    for (i in 0 until N) {
        arr[i] = readln().toInt()

        for (j in i downTo 0) {
            map[arr[i] + arr[j]] = 0
        }
    }

    for (n1 in arr) {
        for (n2 in arr) {
            if (map[n1 - n2] != null) r = maxOf(r, n1)
        }
    }

    println(r)
}