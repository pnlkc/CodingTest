fun main() {
    val N = readln().toInt()
    val arr = Array(N) { "" }

    for (i in 0 until N) {
        arr[i] = readln()
    }

    val sortedArr = arr.sorted()
    val sortedDescendingArr = arr.sortedDescending()
    var isInc = true
    var isDec = true

    for (i in 0 until N) {
        if (arr[i] != sortedArr[i]) isInc = false
        if (arr[i] != sortedDescendingArr[i]) isDec = false
    }

    if (isInc) println("INCREASING")
    else if (isDec) println("DECREASING")
    else println("NEITHER")
}