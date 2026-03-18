fun main() {
    val studentName: String = "Yhordanny"
    val middleName: String? = null

    val displayMiddle = middleName ?: "No Middle Name"

    println("Welcome, $studentName $displayMiddle!")
}