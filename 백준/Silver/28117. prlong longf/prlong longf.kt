fun main() {
    val n = readln().toInt()
    val str = readln()
    val list = IntArray(21) { 1 }
    var result = 1

    (2..20).forEach { list[it] = list[it - 1] + list[it - 2] }

    val temp = str.replace("long", ".")
    var cnt = 0

    for (c in temp) {
        if (c == '.') {
            cnt++
        } else {
            if (cnt != 0) result *= list[cnt]
            cnt = 0
        }
    }

    if (cnt != 0) result *= list[cnt]

    println(result)
}