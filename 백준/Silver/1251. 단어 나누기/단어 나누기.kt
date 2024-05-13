fun main() {
    val word = readln()
    val list = mutableSetOf<String>()

    for (i in 0 until word.length - 2) {
        for (j in i + 1 until word.length - 1) {
            val f = word.slice(0..i)
            val m = word.slice(i + 1..j)
            val e = word.slice(j + 1..word.lastIndex)

            list.add(f.reversed() + m.reversed() + e.reversed())
        }
    }
    
    println(list.toList().minOf { it })
}