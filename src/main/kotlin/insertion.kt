const val ZERO = 0
const val ONE = 1

fun insertionSort(intList: MutableList<Int>) {
    val length = intList.size

    // Find the key
    for (index in ONE until length) {
        var key = intList[index]
        var lastIndex = index - ONE // Last index of sorted list

        // Find the place to insert
        while (lastIndex >= ZERO && intList[lastIndex] > key) {
            intList[lastIndex + ONE] = intList[lastIndex]  // Shift element to right
            --lastIndex
        }
        intList[lastIndex + 1] = key // Insert element
    }
}

fun printList(intList: MutableList<Int>) {
    intList.forEach { print("$it ") }
}

fun main() {
    var intList = mutableListOf(12, 20, 11, 10, 14, 16, 15, 10)
    insertionSort(intList)
    printList(intList)
}