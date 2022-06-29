package scopeFunctions

import scopeFunctions.Person


fun main() {
    letScope()
    letNullCheck()
    letExample()
}

// Introducing an expression as a variable in local scope
fun letExample() {
    Person("Krishna", 35, "Mysore").let {
        println(it)
        it.moveTo("Munich")
        it.incrementAge()
        println(it)
    }
}

// Introducing an expression as a variable in local scope
fun letScope() {
    val numbers = mutableListOf("one", "two", "three", "four", "five")
    numbers.map { it.length }.filter { it > 3 }.let(::println)
}


// Executing a lambda on non-null objects
fun letNullCheck() {
    val numbers = mutableListOf("one", null, "three", "four", "five")
    numbers.forEach{
        it?.let { if (it.length > 3) print("${it.length} ") }
    }
    println()
}
