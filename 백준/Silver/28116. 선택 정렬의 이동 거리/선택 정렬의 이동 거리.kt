fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() - 1 }.toIntArray()
    val idxArr = IntArray(n)
    val result = IntArray(n)

    for (i in 0 until n) {
        idxArr[arr[i]] = i
    }

    for (i in 0 until n) {
        val idx = idxArr[i]

        arr[idx] = arr[i]
        arr[i] = i
        idxArr[i] = i
        idxArr[arr[idx]] = idx
        result[arr[idx]] += idx - i
        result[i] += idx - i
    }

    println(result.joinToString(" "))
}