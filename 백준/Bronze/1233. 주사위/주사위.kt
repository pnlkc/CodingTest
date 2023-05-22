fun main() {
    val (s1, s2, s3) = readln().split(' ').map(String::toInt)
    val arr = IntArray(s1 * s2 * s3 + 1)

    for (i in 1..s1) {
        for (j in 1..s2) {
            for (k in 1..s3) {
                arr[i + j + k]++
            }
        }
    }

    println(arr.indexOfFirst { it == arr.maxOrNull()!! })
}