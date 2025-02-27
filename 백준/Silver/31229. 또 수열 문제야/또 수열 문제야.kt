fun main() {
    val NUM = 100_000
    val N = readln().toInt()
    val arr = IntArray(N)
    val pArr = BooleanArray(NUM + 1) { true }

    for (i in 2..NUM) {
        var num = i + i

        while (num <= NUM) {
            pArr[num] = false
            num += i
        }
    }

    var cnt = 0

    for (i in 2..NUM) {
        if (pArr[i]) arr[cnt++] = i
        if (cnt >= N) break
    }

    println(arr.joinToString(" "))
}