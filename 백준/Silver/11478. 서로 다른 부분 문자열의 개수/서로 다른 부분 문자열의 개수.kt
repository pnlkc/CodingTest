fun main() {
    val s = readln()
    val set = mutableSetOf<String>()
    for (i in s.indices) {
        var string = ""
        for (j in i..s.lastIndex) {
            string += s[j]
            set.add(string)
        }
    }
    println(set.size)
}