package com.artiuil.lab.algorithms.leetcode.task10

fun main() {
    val n = 25
    println("F($n) = ${fibMemo(n)}")
    println("F($n) = ${fibTab(n)}")
}
fun fibMemo(n: Int): Long {
    val memo = LongArray(n + 1) { -1 }
    return fibHelper(n, memo)
}

fun fibHelper(n: Int, memo: LongArray): Long {
    if (n == 0) return 0
    if (n == 1) return 1
    if (memo[n] != -1L) {
        return memo[n]
    }
    memo[n] = fibHelper(n - 1, memo) + fibHelper(n - 2, memo)
    return memo[n]
}

fun fibTab(n: Int): Long {
    if (n == 0) return 0
    val dp = LongArray(n + 1)
    dp[0] = 0
    dp[1] = 1
    for (i in 2..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    return dp[n]
}

// Bad Solution
// You will cal fib() n times. If n == 25, fib(2) will find in all n times while n != 1
fun fib(n: Int): Long {
    if (n == 0) return 0
    if (n == 1) return 1
    return fib(n - 1) + fib(n - 2)
}