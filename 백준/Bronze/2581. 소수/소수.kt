fun main() {
    val m = readln().toInt()
    val n = readln().toInt()
    val list = mutableListOf<Int>()
    
    for (i in m..n) {
        var count = 0
        for (j in 1..i) {
            if (i % j == 0) count += 1
            if (count > 2) break
        }
        if (i != 1 && count == 2) list.add(i)
    }
    
    if (list.isEmpty()) {
        println(-1)
    } else {
        println(list.sum())
        println(list.first())
    }
}