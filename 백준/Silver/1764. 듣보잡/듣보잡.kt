fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val nMap = mutableMapOf<String, Boolean>()
    val nmList = mutableListOf<String>()
    
    // n을 map에 추가
    repeat(n) {
        nMap[readln()] = true
    }
    
    // n에 m이 있으면 nmList에 m을 추가
    repeat(m) {
        val input = readln()
        if (nMap[input] != null) nmList.add(input)
    }
    
    // nmList 사전순 정렬
    nmList.sort()
    
    // 듣보잡 수 출력
    println(nmList.size)
    
    // 명단 출력
    nmList.forEach { println(it) }
}