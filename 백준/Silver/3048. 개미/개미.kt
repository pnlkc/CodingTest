fun main() {
    val (N1, N2) = readln().split(" ").map { it.toInt() }
    val a = readln()
    val b = readln()
    val T = readln().toInt()
    val arr = a.reversed().toCharArray() + b.toCharArray()
    val map = mutableMapOf<Char, Boolean>()

    a.forEach { map[it] = false }
    b.forEach { map[it] = true }

    for (i in 1..T) {
       var idx = 0

        while (idx < arr.lastIndex) {
            if (!map[arr[idx]]!! && map[arr[idx + 1]]!!) {
                val temp = arr[idx]
                arr[idx] = arr[idx + 1]
                arr[idx + 1] = temp
                idx++
            }

            idx++
        }
    }

    println(arr.joinToString(""))
}