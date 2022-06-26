package serilization

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import java.io.File
import java.util.*

enum class Grade{
    A,
    B,
    C,
    D,
    E;

    companion object {
        private val VALUES: List<Grade> = Collections.unmodifiableList(values().toMutableList())
        private val SIZE: Int = VALUES.size
        private val RANDOM: Random = Random()
        fun randomGrade(): Grade {
            return VALUES[RANDOM.nextInt(SIZE)]
        }
    }
}

@Serializable
data class Employee(val name: String,
                    @EncodeDefault val id: Int = 100,
                    val grade: Grade,
                    val last3MonthSalary: List<Int>)

fun main() {
    val nameSet = setOf("Iapetus", "Arash", "Melia", "Irene", "Lugh")
    val employeeList = emptyList<Employee>().toMutableList()
    for (index in 1..5) {
        employeeList.add(Employee(name = nameSet.random(), index, Grade.randomGrade(), getLast3MonthSalary()))
    }
    val json = Json { prettyPrint = true }
    val jsonFile = File("serial.json")
    jsonFile.writeText(json.encodeToString(employeeList))
}

fun getLast3MonthSalary(): MutableList<Int> {
    val salaryList = emptyList<Int>().toMutableList()
    for (index in 1..3) {
        salaryList.add((50_000..60_000).random())
    }

    return salaryList
}