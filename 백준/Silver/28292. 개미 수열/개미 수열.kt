fun main() {
    val N = readln().toInt()
    
    if (N >= 6) {
        println(3)
        return
    }
    
    var s = "1"
    
    for (i in 1 until N) {
        var temp = ""
        var str = ""

        for (j in s.indices) {
            if (str.isNotBlank() && s[j] != str.last()) {
                temp += "${str.first()}${str.length}"
                str = "${s[j]}"
            } else {
                str += s[j]
            }
        }

        temp += "${str.first()}${str.length}"
        s = temp
    }

    println(s.maxOf { it })
}