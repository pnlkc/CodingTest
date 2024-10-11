fun main() {
    val s = readln()
    val t = readln()
    var str1 = ""
    var str2 = ""
    val num = s.length * t.length

    repeat(num / s.length) {
        str1 += s
    }

    repeat(num / t.length) {
        str2 += t
    }

    println(if (str1 == str2) 1 else 0)
}