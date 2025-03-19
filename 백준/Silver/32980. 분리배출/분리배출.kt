fun main() {
    val N = readln().toInt()
    var result = 0L
    val arr = Array(N) { "" }

    for (i in 0 until N) {
        arr[i] = readln()
    }

    val list = readln().split(" ").map { it.toInt() }
    val map = mutableMapOf<Char, Int>()

    map['P'] = list[0]
    map['C'] = list[1]
    map['V'] = list[2]
    map['S'] = list[3]
    map['G'] = list[4]
    map['F'] = list[5]
    map['O'] = readln().toInt()

    for (i in 0 until N) {
        result += if (arr[i].toCharArray().distinct().size > 1) {
            arr[i].length * map['O']!!
        } else {
            minOf(arr[i].length * map[arr[i].first()]!!, arr[i].length * map['O']!!)
        }
    }

    print(result)
}