fun main() {
    val M = readln().toInt()
    val map = mutableMapOf<String, Int>()
    val RATIO = 1.618

    for (i in 0 until M) {
        val (s, x) = readln().split(" ")

        if (map[s] == null) map[s] = x.toInt()
        else map[s] = map[s]!! + x.toInt()
    }

    val keys = map.keys.toList()

    for (i in 0 until map.size) {
        for (j in 0 until map.size) {
            if (i == j) continue

            val a = (minOf(map[keys[i]]!!, map[keys[j]]!!) * RATIO).toInt()
            val b = maxOf(map[keys[i]]!!, map[keys[j]]!!)

            if (a == b) {
                println("Delicious!")
                return
            }
        }
    }

    println("Not Delicious...")
}