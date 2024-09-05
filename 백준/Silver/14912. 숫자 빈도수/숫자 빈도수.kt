fun main() {
    val (n, target) = readln().split(" ").map { it.toInt() }
    val arr = IntArray(10)

    for (i in 1..n) {
        val list = i.toString().toCharArray().map { it.digitToInt() }

        for (j in 0..9) {
            arr[j] += list.count { it == j }
        }
    }

    println(arr[target])
}