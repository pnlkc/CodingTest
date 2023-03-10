fun main() {
    val s = readln()
    val set = mutableSetOf<String>()
    for (i in s.indices) {
        val string = StringBuilder()
        for (j in i..s.lastIndex) {
            string.append(s[j])
            set.add(string.toString())
        }
    }
    println(set.size)
}