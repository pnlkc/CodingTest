fun main() {
    val S = readln()
    val lL = charArrayOf('q', 'w', 'e', 'r', 't', 'y', 'a', 's', 'd', 'f', 'g', 'z', 'x', 'c', 'v', 'b')
    var l = 0
    var r = 0
    var shift = 0
    var space = 0

    for (c in S) {
        if (c == ' ') space++
        else {
            if (c.isUpperCase()) shift++
            if (lL.contains(c.lowercaseChar())) l++ else r++
        }
    }

    for (i in 0 until shift + space) {
        if (l <= r) l++ else r++
    }

    println("$l $r")
}