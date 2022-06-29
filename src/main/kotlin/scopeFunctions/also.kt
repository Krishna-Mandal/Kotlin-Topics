package scopeFunctions

fun main() {
    var p = Person("Krishna", 35, "Mysore")
        .also { println(it) }
        .apply {
            incrementAge()
            moveTo("Munich")
        }
        .also { println(it) }
}