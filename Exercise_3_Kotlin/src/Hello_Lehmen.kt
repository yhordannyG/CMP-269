
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.http.*
import io.ktor.server.http.content.*
import kotlinx.serialization.Serializable

fun main() {
    embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            json()
        }

        routing {
            get("/") {
                call.respondText("Server is online at Lehman College.")
            }
            get("/greet/{name}") {
                val name = call.parameters["name"] ?: "Student"
                call.respondText("Hello, $name! Welcome to CMP 269.")
            }

            val grades = mapOf("123" to 95, "456" to 82)
            get("/grade/{studentId}") {
                val studentId = call.parameters["studentId"]
                val grade = grades[studentId]
                if (grade != null) {
                    call.respondText("Grade for student $studentId: $grade")
                } else {
                    call.respond(HttpStatusCode.NotFound, "Student not found")
                }
            }

            static("/static") {
                resources("static")
            }

            @Serializable
            data class Stock(val symbol: String, val price: Double)

            get("/api/stock/{symbol}") {
                val symbol = call.parameters["symbol"] ?: "UNKNOWN"
                val stock = Stock(symbol, 150.25)
                call.respond(stock)
            }
        }
    }.start(wait = true)
}