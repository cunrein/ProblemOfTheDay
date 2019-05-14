package googleProblems

import java.util.*

// Given a string of parentheses, write a function to compute the minimum number of parentheses to be removed to make
// the string valid (i.e. each open parenthesis is eventually closed).
//
// For example, given the string "()())()", you should return 1. Given the string ")(", you should return 2,
// since we must remove all of them.

val OPEN = '('
val CLOSE = ')'

fun findMissingParentheses(str: String): Int {

    val stack = Stack<Char>()
//    val rev = str.toCharArray().reversed()
    str.toCharArray().forEach {
        if (!stack.empty() && isMatch(stack.peek(), it))
            stack.pop()
        else
            stack.push(it)
    }

    return stack.size
}

fun isMatch(value: Char, target: Char): Boolean {
    return OPEN == value && CLOSE == target
}

fun main() {
    println(findMissingParentheses("()())()"))
    println(findMissingParentheses(")("))
    println(findMissingParentheses("()()))))()"))
    println(findMissingParentheses(")()())("))
    println(findMissingParentheses("(((()()))()())"))
}