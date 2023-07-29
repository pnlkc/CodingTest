fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map(String::toInt)
    val map = mutableMapOf<Int, Int>()

    for (i in arr.indices) {
        map[arr[i]] = 0
    }

    for (i in arr.indices) {
        var num = arr[i]
        while (num <= 1_000_000) {
            if (map[num] != null) {
                map[num] = map[num]!! - 1
                map[arr[i]] = map[arr[i]]!! + 1
            }
            num += arr[i]
        }
    }

    println(map.values.joinToString(" "))
}