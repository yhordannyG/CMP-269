fun routeRequest(path: String, user: String?): String {
    if (path == "/home") {
        return "Welcome to the Lehman Homepage, ${user ?: "Guest"}!"
    } else if (path == "/grades") {
        if (user == null) {
            return "Error: Unauthorized access to grades."
        } else {
            return "Loading grades for $user..."
        }
    } else {
        return "404: Path $path not found."
    }
}

fun main() {
    println("Exercise 3:")
    println(routeRequest("/home", "Alice"))
    println(routeRequest("/grades", "Bob"))
    println(routeRequest("/grades", null))
    println(routeRequest("/unknown", null))
}