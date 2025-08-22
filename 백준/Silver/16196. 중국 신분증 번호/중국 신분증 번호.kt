fun main() {
    val input = readln()
    val a = input.slice(0 until 6) // 지역 코드
    val b = input.slice(6 until 14) // 생일 코드
    val c = input.slice(14 until 17) // 순서 코드
    val d = input.last().toString() // 체크섬 코드
    val lN = readln().toInt()
    val cM = mutableMapOf<String, Boolean>()

    repeat(lN) {
        val code = readln()

        cM[code] = true
    }

    if (cM[a] == null) { // 지역 코드 체크
        println("I")
        return
    }

    val yyyy = b.slice(0..3).toInt()
    val mm = b.slice(4..5).toInt()
    val dd = b.slice(6..7).toInt()

    if (yyyy !in 1900..2011 || mm !in 1..12) { // 년월 체크
        println("I")
        return
    }

    if (listOf(1, 3, 5, 7, 8, 10, 12).contains(mm) && dd !in 1..31) { // 일 체크1
        println("I")
        return
    }

    if (listOf(4, 6, 9, 11).contains(mm) && dd !in 1..30) { // 일 체크2
        println("I")
        return
    }

    if ((yyyy % 4 == 0 && yyyy % 100 != 0) || yyyy % 400 == 0) { // 윤년 체크
        if (mm == 2 && dd !in 1..29) {
            println("I")
            return
        }
    } else { // 평년 체크
        if (mm == 2 && dd !in 1..28) {
            println("I")
            return
        }
    }

    if (c == "000") { // 순서 코드 체크
        println("I")
        return
    }

    var result = 0
    var num = 1

    repeat(17) {
        num *= 2
    }

    for (i in 0..16) {
        result += input[i].digitToInt() * num
        result %= 11
        num /= 2
    }

    val x = (12 - result) % 11

    // 체크섬 코드 체크
    if (x == 10) {
        if (d != "X") {
            println("I")
            return
        }
    } else {
        if (x.toString() != d) {
            println("I")
            return
        }
    }

    println(if (c.toInt() % 2 == 0) "F" else "M")
}