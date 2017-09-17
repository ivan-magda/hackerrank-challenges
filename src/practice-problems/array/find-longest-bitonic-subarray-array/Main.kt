
fun getLongestBitonicSubarrayNaive(array: Array<Int>): Int {
    val longestIncreasingSubarray = Array<Int>(array.size, { 0 })
    longestIncreasingSubarray[0] = 1

    for (i in 1 until array.size) {
        longestIncreasingSubarray[i] = 1
        if (array[i - 1] < array[i]) {
            longestIncreasingSubarray[i] = longestIncreasingSubarray[i - 1] + 1
        }
    }

    val longestDecreasingSubarray = Array<Int>(array.size, { 0 })
    longestDecreasingSubarray[array.lastIndex] = 1

    for (i in array.lastIndex - 1 downTo 0) {
        longestDecreasingSubarray[i] = 1
        if (array[i] > array[i + 1]) {
            longestDecreasingSubarray[i] = longestDecreasingSubarray[i + 1] + 1
        }
    }

    var lbsLength = 1
    var startIndex = 0
    var endIndex = 0

    for (i in 0 until array.size) {
        if (lbsLength < longestIncreasingSubarray[i] + longestDecreasingSubarray[i] - 1) {
            lbsLength = longestIncreasingSubarray[i] + longestDecreasingSubarray[i] - 1
            startIndex = i - longestIncreasingSubarray[i] + 1
            endIndex = i + longestDecreasingSubarray[i] - 1
        }
    }

    println("The length of longest bitonic sub-array is $lbsLength")
    println("The longest bitonic sub-array is [$startIndex, $endIndex]")

    return lbsLength
}

fun getLongestBitonicSubarrayImproved(array: Array<Int>): Int {
    var endIndex = 0
    var maxLength = 0

    var i = 0
    while (i + 1 < array.size) {
        var currentLength = 1

        while (i + 1 < array.size && array[i] < array[i + 1]) {
            i++
            currentLength++
        }

        while (i + 1 < array.size && array[i] > array[i + 1]) {
            i++
            currentLength++
        }

        if (currentLength > maxLength) {
            maxLength = currentLength
            endIndex = i
        }
    }

    println("The length of longest bitonic sub-array is $maxLength")
    println("The longest bitonic sub-array is [${endIndex - maxLength + 1}, $endIndex]")

    return maxLength
}

fun main(args: Array<String>) {
    val array = arrayOf(3, 5, 8, 4, 5, 9, 10, 8, 5, 3, 4)
    getLongestBitonicSubarrayNaive(array)
    getLongestBitonicSubarrayImproved(array)
}
