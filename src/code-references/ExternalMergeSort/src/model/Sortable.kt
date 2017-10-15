package model

interface Sortable<T> where T : Comparable<T> {
    fun sort(array: Array<T>)
}
