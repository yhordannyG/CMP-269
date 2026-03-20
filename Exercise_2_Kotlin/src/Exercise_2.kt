fun describeStatus(code: Int): String {
    when (code) {
        in 200..299 -> return "Success: The request was fulfilled."
        in 400..499 -> return "Client Error: Check your URL or parameters."
        in 500..599 -> return "Server Error: The Lehman Server is having trouble."
        else -> return "Unknown status code."
    }
}

fun main() {
    println("Exercise 2:")
    println("201 -> " + describeStatus(201))
    println("404 -> " + describeStatus(404))
    println("503 -> " + describeStatus(503))
    println("123 -> " + describeStatus(123))
}