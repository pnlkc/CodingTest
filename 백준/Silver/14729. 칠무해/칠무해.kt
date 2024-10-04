fun main() {
    val N = readln().toInt()
    val arr = FloatArray(N)

    for (i in 0 until N) {
        arr[i] = readln().toFloat()
    }

    arr.sort()

    for (i in 0 until 7) {
        println(String.format("%.3f", arr[i]))
    }
}