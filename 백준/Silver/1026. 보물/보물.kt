fun main() {
    val N = readln().toInt()
    var arr1 = readln().split(" ").map { it.toInt() }
    var arr2 = readln().split(" ").map { it.toInt() }
    var result = 0

    arr1 = arr1.sorted()
    arr2 = arr2.sortedDescending()

    for (i in 0 until N) {
        result += arr1[i] * arr2[i]
    }

    println(result)
}