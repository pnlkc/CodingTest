fun main() {
    val arr = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    var result = 0

    for (i in 0..2) {
        result += arr[i] / 3
        arr[i] %= 3
    }

    arr.sort()

    while (arr.count { it != 0 } > 0) {
        if (arr[0] != 0) {
            arr[0]--
            arr[1]--
            arr[2]--
        } else {
            if (arr[1] != 0) {
                arr[1]--
                arr[2]--
            } else {
                arr[2] = 0
            }
        }

        result++
        arr.sort()
    }

    println(result)
}