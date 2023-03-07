fun main() {
    val list = mutableListOf<Int>()

    repeat(5) {
        list.add(readln().toInt())
    }
    
    list.sort()
    
    println(list.average().toInt())
    println(list[2])
}