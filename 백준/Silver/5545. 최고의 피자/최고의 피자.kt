fun main() {
    val N = readln().toInt()
    val (A, B) = readln().split(" ").map { it.toInt() }
    val C = readln().toInt()
    val arr = IntArray(N)

    for (i in 0 until N) {
        arr[i] = readln().toInt()
    }

    arr.sortDescending()

    var price = A
    var calorie = C
    var result = calorie / price

    for (i in 0 until N) {
        price += B
        calorie += arr[i]
        result = maxOf(result, calorie / price)
    }

    println(result)
}