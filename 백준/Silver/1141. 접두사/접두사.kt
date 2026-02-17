fun main() {
    val n = readln().toInt()
    var arr = Array(n) { "" }

    for (i in 0 until n) {
        arr[i] = readln()
    }

    arr = arr.distinct().sortedDescending().toTypedArray()
    
    println(arr.filter { str -> arr.count { it.startsWith(str) } == 1 }.size)
}