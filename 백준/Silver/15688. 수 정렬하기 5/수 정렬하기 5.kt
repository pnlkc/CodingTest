fun main() {
    val sb = StringBuilder()
    val N = readln().toInt()
    val arr = IntArray(N)

    for (i in 0 until N) {
        arr[i] = readln().toInt()
    }

    arr.sort()

    arr.forEach { 
        sb.appendLine(it)
    }
    
    print(sb)
}