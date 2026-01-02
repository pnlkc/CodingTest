fun main() {
    readln()
    val n = readln().toInt()
    val map = mutableMapOf<String, Int>()

    map["swi"] = 1

    for (i in 0 until n) {
        val name =  readln()

        map[name] = 1
    }

    val m = readln().toInt()

    if (map["dongho"] != null) {
        println("dongho")
        return
    }

    for (i in 0 until m) {
        val name = readln()

        if (map[name] != null) {
            map[name] = map[name]!! + 1
        }
    }

    if (map.count { (key, value) -> value == 1 } == 1) {
        map.filter { (key, value) -> value == 1 }.keys.forEach {
            println(it)
            return
        }
    }

    if (map["bumin"] == 1) {
        println("bumin")
        return
    }

    if (map["cake"] == 1) {
        println("cake")
        return
    }

    if (map["lawyer"] == 1) {
        println("lawyer")
        return
    }

    map.filter { (key, value) -> key != "swi" && value == 1 }.keys.sorted().forEach {
        println(it)
        return
    }

    println("swi")
}