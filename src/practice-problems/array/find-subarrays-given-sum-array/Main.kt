fun <T> Array<T>.print(start: Int, end: Int) {
    print("[$start..$end] -- { ")
    for (i in start..end) {
        print("${get(i)} ")
    }
    println("}")
}

// This approach takes O(n^3) time as subarray sum is calculated in O(1)
// time for each of n^2 subarrays and it takes O(n) time to print a sub-array.
fun printAllSubArraysGivenSumNaive(array: Array<Int>, sum: Int) {
    for (i in 0 until array.size) {
        var currentSum = 0
        for (j in i until array.size) {
            currentSum += array[j]
            if (currentSum == sum) {
                array.print(i, j)
            }
        }
    }
}

// We can also use hashing to find subarrays with given sum in an array by using a map of vector or a multi-map
// for storing end index of all subarrays having given sum.
// 
// The idea is to traverse the given array, and maintain sum of elements seen so far.
// At any index i, let k be the difference between sum of elements seen so far and given sum.
// Now if key k is present in the map, there exists at-least one subarray with the given sum ending at current index i
// and we print all such subarrays.
fun printAllSubArraysGivenSumHashing(array: Array<Int>, sum: Int) {
    val hashMap = HashMap<Int, ArrayList<Int>>()

    // To handle the case when the subarray with given sum starts from 0th index.
    hashMap.getOrPut(0, { ArrayList() }).add(-1)

    var currentSum = 0

    for (index in 0 until array.size) {
        currentSum += array[index]
        val difference = currentSum - sum

        // Check if there exists at-least one sub-array with given sum.
        if (hashMap.containsKey(difference)) {
            val list = hashMap[difference]
            for (value in list!!) {
                array.print(value + 1, index)
            }
        }

        hashMap.getOrPut(currentSum, { ArrayList() }).add(index)
    }
}

fun main(args: Array<String>) {
    val array = arrayOf(3, 4, -7, 1, 3, 3, 1, -4)

    println("Naive:")
    printAllSubArraysGivenSumNaive(array, 7)

    println("Hashing:")
    printAllSubArraysGivenSumHashing(array, 7)
}
