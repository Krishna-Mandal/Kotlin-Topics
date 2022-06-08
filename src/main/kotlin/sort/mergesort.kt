package sort

// Merges two sub list of numbers.
// First sublist is numbers[start..mid]
// Second sublist is arr[mid+1..end]
fun merge(numbers: MutableList<Int>, start: Int, mid: Int, end: Int) {
    val firstListSize = mid - start + 1
    val secondListSize = end - mid
    val tmpListFirst = MutableList<Int> (firstListSize) {0}
    val tmpListSecond = MutableList<Int> (secondListSize) {0}

    // Copy data to temp arrays
    for (index in 0 until firstListSize) {
        tmpListFirst[index] = numbers[start + index]
    }

    for (index in 0 until secondListSize) {
        tmpListSecond[index] = numbers[mid + 1+ index]
    }

    // initial index of sub list
    var firstIndex = 0
    var secondIndex = 0

    // initial index of merged sub list
    var mergeIndex = start

    while (firstIndex < firstListSize && secondIndex < secondListSize) {
        if (tmpListFirst[firstIndex] <= tmpListSecond[secondIndex]) {
            numbers[mergeIndex] = tmpListFirst[firstIndex]
            ++firstIndex
        } else {
            numbers[mergeIndex] = tmpListSecond[secondIndex]
            ++secondIndex
        }
        ++mergeIndex
    }

    while (firstIndex < firstListSize) {
        numbers[mergeIndex] = tmpListFirst[firstIndex]
        ++firstIndex
        ++mergeIndex
    }

    while (secondIndex < secondListSize) {
        numbers[mergeIndex] = tmpListSecond[secondIndex]
        ++secondIndex
        ++mergeIndex
    }
}


fun sort(numbers: MutableList<Int>, start: Int, end: Int) {
    if (start < end) {
        val mid = (start + end) / 2

        sort(numbers, start, mid)
        sort(numbers, mid + 1, end)

        merge(numbers, start, mid, end)
    }
}

fun printMergedList(intList: MutableList<Int>) {
    intList.forEach { print("$it ") }
}

fun main() {
    val intList = mutableListOf(12, 20, 11, 10, 14, 16, 15, 10)
    sort(intList, 0, intList.size - 1)
    printMergedList(intList)
}