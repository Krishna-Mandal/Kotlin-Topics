package serilization

import serilization.Employee
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import java.io.File

fun main() {
    val jsonFile = File("serial.json")
    val someObjects = Json.decodeFromString<List<Employee>>(jsonFile.readText())

    for (obj in someObjects) {
        println(obj)
    }

}