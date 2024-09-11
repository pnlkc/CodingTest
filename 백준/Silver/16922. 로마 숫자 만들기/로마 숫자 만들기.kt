val pick = IntArray(20)
val arr = Array(21) { mutableSetOf<Int>() }

fun main() {
    val N = readln().toInt()

    arr[0].add(0)
    pick(0, N)

    println(arr[N].size)
}

fun pick(idx: Int, N: Int) {
    if (idx == N) {
        var num = 0

        for (i in 0 until N) {
            num += pick[i]
        }

        return
    }

    for (num in arr[idx]) {
        arr[idx + 1].add(num + 1)
        arr[idx + 1].add(num + 5)
        arr[idx + 1].add(num + 10)
        arr[idx + 1].add(num + 50)
    }

    pick(idx + 1, N)
}