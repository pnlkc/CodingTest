fun main() {
    val N = readln().toInt()

    if (N == 1) {
        println(2)
    } else if (N == 2) {
        println("3 6")
    } else {
        val arr = IntArray(N)

        arr[0] = 0

        for (i in 1 until N) {
            arr[i] = i * 2
        }

        val sum = arr.sumOf { it.toLong() }

        for (i in 3 until 1_000_000 step 2) {
            if ((sum + i) % i == 0L) {
                arr[0] = i
                break
            }
        }

        println(arr.joinToString(" "))
    }
}
