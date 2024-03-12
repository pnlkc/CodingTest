fun main() {
    val s1 = readln()
    val s2 = readln()
    var result = 0
    var i1 = 0
    var i2 = 0

    while (i1 < s1.length) {
        if (s1[i1] == s2[i2]) {
            val prev = i1

            while (i1 < s1.length && i2 < s2.length && s1[i1] == s2[i2]) {
                i1++
                i2++
            }

            if (i2 == s2.length) {
                result++
            } else {
                i1 = prev + 1
            }
        } else {
            i1++
        }

        i2 = 0
    }

    println(result)
}