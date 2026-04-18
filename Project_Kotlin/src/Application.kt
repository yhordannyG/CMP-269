package com.example

import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.Base64

fun Application.module() {

    install(ContentNegotiation) {
        json()
    }

    routing {

        get("/") {
            call.respondResource("static/index.html")
        }

        get("/api/student/{id}") {
            val id = call.parameters["id"]

            if (id == null) {
                return@get call.respond(HttpStatusCode.BadRequest, "Missing ID")
            }

            val student = Database.studentDB[id]

            if (student == null) {
                return@get call.respond(HttpStatusCode.NotFound, "Student not found")
            }

            val safeStudent = student.copy(
                major = student.major ?: "Undecided"
            )

            call.respond(safeStudent)
        }

        get("/generate-id") {
            val sid = call.request.queryParameters["sid"]

            if (sid == null) {
                return@get call.respond(HttpStatusCode.BadRequest, "Missing sid")
            }

            val student = Database.studentDB[sid]

            if (student == null) {
                return@get call.respond(HttpStatusCode.NotFound, "Student not found")
            }

            val safeMajor = student.major ?: "Undecided"

            val rawData = "${student.id}|${student.accessLevel}|$safeMajor"
            val encoded = Base64.getEncoder().encodeToString(rawData.toByteArray())

            val base64Qr = generateQrBase64(encoded)

            call.respondBytes(
                Base64.getDecoder().decode(base64Qr),
                ContentType.Image.PNG
            )
        }

        staticResources("/static", "static")
    }
}