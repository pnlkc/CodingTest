fun main() {
    val N = readln().toInt()
    var M = 0L
    var money = 0L
    var maxMoney = 0L

    for (tc in 1..N) {
        val (a, b) = readln().split(" ").map { it.toLong() }

        if (money + a >= 0) { // 입금이거나 현재 잔액에서 출금이 가능한 경우
            if (money + a != b) { // 입출금 후 잔액이 맞지 않는 경우
                println(-1)
                return
            }
        } else { // 현재 잔액에서 출금이 불가능한 경우
            val fullMoney = b - (money + a)

            maxMoney = maxOf(maxMoney, b)

            if (M == 0L) { // 아직 충전 단위 설정이 안된 경우
                M = fullMoney
            } else { // 이미 충전 단위 설정이 된 경우
                val gcd = gcd(fullMoney, M)

                if (M <= maxMoney || gcd <= maxMoney) { // 최소 충전 단위보다 잔액이 많이 남은 상황이 존재하는 경우
                    println(-1)
                    return
                }

                M = gcd
            }
        }

        money = b
    }

    println(maxOf(1, M))
}

fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)