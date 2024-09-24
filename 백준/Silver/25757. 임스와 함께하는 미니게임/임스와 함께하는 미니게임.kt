fun main() {
    val (nStr, c) = readln().split(" ")
    val N = nStr.toInt()
    val set = mutableSetOf<String>()
    
    for (i in 1..N) {
        set.add(readln())
    }
    
    when (c) {
        "Y" -> println(set.size)
        "F" -> println(set.size / 2)
        "O" -> println(set.size / 3) 
    }
}