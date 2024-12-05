fun main() {
    val N = readln().toInt()
    val list = mutableListOf<String>()

    p@ for (i in 0 until N) {
        val str = readln()

        for (e in list) {
            if (e.length == str.length * 2 && e.contains(str)) continue@p
        }

        list.add(str + str)
    }

    println(list.size)
}