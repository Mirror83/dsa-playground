package org.example.array

fun hourglassSum(arr: Array<Array<Int>>): Int {
    var maxSum = Int.MIN_VALUE

    for (i in 0..3) {
        for (j in 0..3) {
            // Top
            val top = arr[i][j] + arr[i][j+1] + arr[i][j+2]
            // Middle
            val middle = arr[i+1][j+1]
            // Bottom
            val bottom = arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]

            val sum = top + middle + bottom
            println("sum: $sum")
            if (sum > maxSum) {
                maxSum = sum
                println("max sum: $maxSum, indices:($i, $j)")
            }
        }
    }

    return maxSum
}

fun main() {
    val arr = arrayOf(
        arrayOf(-9, -9, -9,  1,  1,  1),
        arrayOf( 0, -9,  0,  4,  3,  2),
        arrayOf(-9, -9, -9,  1,  2,  3),
        arrayOf( 0,  0,  8,  6,  6,  0),
        arrayOf( 0,  0,  0, -2,  0,  0),
        arrayOf( 0,  0,  1,  2,  4,  0),
    )

    println(hourglassSum(arr))
}