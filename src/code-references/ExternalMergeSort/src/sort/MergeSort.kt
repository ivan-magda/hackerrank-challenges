package sort

import model.Sortable

class MergeSort : Sortable<Int> {
    override fun sort(array: Array<Int>) {
        sort(array, Array(array.size, { 0 }), 0, array.lastIndex)
    }

    private fun sort(array: Array<Int>, buffer: Array<Int>, start: Int, end: Int) {
        if (start < end) {
            val middleIndex = start + (end - start) / 2

            sort(array, buffer, start, middleIndex)
            sort(array, buffer, middleIndex + 1, end)
            merge(array, buffer, start, middleIndex, end)
        }
    }

    private fun merge(array: Array<Int>, buffer: Array<Int>, start: Int, middle: Int, end: Int) {
        var copyIndex = start
        var left = start
        var right = middle + 1

        while (left <= middle && right <= end) {
            if (array[left] <= array[right]) {
                buffer[copyIndex++] = array[left++]
            } else {
                buffer[copyIndex++] = array[right++]
            }
        }

        System.arraycopy(array, left, buffer, copyIndex, middle - left + 1)
        System.arraycopy(array, right, buffer, copyIndex, end - right + 1)
        System.arraycopy(buffer, start, array, start, end - start + 1)
    }
}
