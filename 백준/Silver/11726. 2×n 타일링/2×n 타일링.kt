fun main() {
    val n = readln().toInt()
    val arr = IntArray(n + 1) { 1 }

    for (i in 2..n) {
        arr[i] = (arr[i - 1] + arr[i - 2]) % 10_007
    }

    println(arr[n])
}