fun main() {
    val N = readln().toInt()
    val arr = Array(N) { "" }

    for (n in 0 until N) {
        arr[n] = readln()
    }

    val length = arr[0].lastIndex

    p@ for (k in length downTo 0) {
        val map = mutableMapOf<String, Boolean>()

        for (i in 0 until N) {
            val str = arr[i].slice(k..length)

            if (map[str] != null) {
                continue@p
            }

            map[str] = true
        }

        println(length - k + 1)
        return
    }
}