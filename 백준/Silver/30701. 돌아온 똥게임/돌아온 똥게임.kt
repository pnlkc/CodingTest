data class Data(val a: Int, val x: Int)

fun main() {
    val (N, D) = readln().split(" ").map { it.toInt() }
    val monsterList = mutableListOf<Data>()
    val equipmentList = mutableListOf<Data>()
    var d = D.toLong()

    for (i in 0 until N) {
        val (a, x) = readln().split(" ").map { it.toInt() }
        if (a == 1) monsterList.add(Data(a, x))
        else equipmentList.add(Data(a, x))
    }

    monsterList.sortBy { it.x }
    equipmentList.sortBy { it.x }

    var mIdx = 0
    var eIdx = 0

    while (true) {
        var isChange = false

        while (mIdx < monsterList.size && monsterList[mIdx].x < d) {
            d += monsterList[mIdx].x
            mIdx++
            isChange = true
        }

        if (eIdx < equipmentList.size) {
            d *= equipmentList[eIdx].x
            eIdx++
            isChange = true
        }

        if (!isChange) break
    }
    
    println(mIdx + eIdx)
}