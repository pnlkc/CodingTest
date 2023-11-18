package com.example.notepad

import java.util.LinkedList

val pN = MutableList(10001) { true }

fun main() {
    val T = readln().toInt()

    init(pN)

    p@ for (tc in 1..T) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        bfs(a, b)
    }
}

fun bfs(a: Int, b: Int) {
    val isVisit = MutableList(10001) { false }
    val q = LinkedList<Pair<Int, Int>>()

    q.offer(a to 0)
    isVisit[a] = true

    while (q.isNotEmpty()) {
        val (cNum, cD) = q.poll()!!

        if (cNum == b) {
            println(cD)
            return
        }


        for (i in 0..3) {
            val cNumToArr = cNum.toString().toCharArray()

            for (j in 0..9) {
                if (i == 0 && j == 0) continue

                cNumToArr[i] = j.digitToChar()
                val newNum = cNumToArr.joinToString("").toInt()

                if (pN[newNum] && !isVisit[newNum]) {
                    q.offer(newNum to (cD + 1))
                    isVisit[newNum] = true
                }
            }
        }
    }

    println("Impossible")
}

fun init(pN: MutableList<Boolean>) {
    for (i in 2..10000) {
        if (!pN[i]) continue

        for (j in 2..(10000 / i)) {
            if (i * j > 10000) continue

            pN[i * j] = false
        }
    }
}