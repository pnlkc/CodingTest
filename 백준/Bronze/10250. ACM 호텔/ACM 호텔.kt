fun main() {
    val testCaseNum = readln().toInt()
    repeat(testCaseNum) {
        val (w, h, target) = readln().split(" ").map { it.toInt() }
        val y = if (target % w == 0) w else target % w
        val xx = (target / w) + if (target % w == 0) 0 else 1
        println("$y" + if(xx < 10) "0$xx" else "$xx")
    }
}