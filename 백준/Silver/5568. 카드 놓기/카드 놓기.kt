val map = mutableMapOf<Int, Boolean>()

fun main() {
    val n = readln().toInt()
    val k = readln().toInt()
    val arr = IntArray(n)

    for (i in 0 until n) {
        arr[i] = readln().toInt()
    }

    calc(k, arr, mutableListOf())

    println(map.keys.size)
}

fun calc(k: Int, arr: IntArray, used: MutableList<Int>) {
    if (used.size == k) {
        val sb = StringBuilder()

        for (i in used) {
            sb.append(arr[i])
        }

        map[sb.toString().toInt()] = true

        return
    }

    for (i in arr.indices) {
        if (!used.contains(i)) {
            val temp = used.toMutableList()
            temp.add(i)
            calc(k, arr, temp)
        }
    }
}