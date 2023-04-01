package com.example.notepad

import java.util.*

fun main() {
    val stack = Stack<Int>()
    val s = StringBuilder()

    repeat(readln().toInt()) {
        val input = readln().split(" ")
        when (input[0]) {
            "push" -> stack.push(input[1].toInt())
            "pop" -> s.append(if (stack.isEmpty()) -1 else stack.pop()).append("\n")
            "size" -> s.append(stack.size).append("\n")
            "empty" -> s.append(if (stack.isEmpty()) 1 else 0).append("\n")
            else -> s.append(if (stack.isEmpty()) -1 else stack.peek()).append("\n")
        }

    }
    
    println(s.toString())
}