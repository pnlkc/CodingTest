package com.example.notepad

import java.util.LinkedList
import kotlin.math.roundToInt
import kotlin.math.sqrt

val pN = MutableList(10001) { false }

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
    p@ for (i in 1000..9999) {
        for (j in 2..sqrt(i.toDouble()).roundToInt()) {
            if (i % j == 0) continue@p
        }

        pN[i] = true
    }
}