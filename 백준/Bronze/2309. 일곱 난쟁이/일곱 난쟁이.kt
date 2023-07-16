var answer = mutableListOf<Int>()

fun main() {
    val arr = IntArray(9)
    
    for (i in 0..8) {
        arr[i] = readln().toInt()
    }
    
    backTracking(arr, mutableListOf(), 0)
    
    println(answer.map { arr[it] }.sorted().joinToString("\n"))
}

fun backTracking(arr: IntArray, used: MutableList<Int>, sum: Int) {
    if (used.size == 7) {
        if (sum == 100) answer = used
        return
    }
    
    for (i in 0..8) {
        if (!used.contains(i)) {
            val temp = used.toMutableList()
            temp.add(i)
            backTracking(arr, temp, sum + arr[i])
        }
    }
}