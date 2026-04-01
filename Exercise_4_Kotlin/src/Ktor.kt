import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.http.*
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.client.j2se.MatrixToImageWriter
import java.io.ByteArrayOutputStream

fun generateQRCodeBytes(text: String): ByteArray {
    val writer = QRCodeWriter()
    val bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, 300, 300)

    val stream = ByteArrayOutputStream()
    MatrixToImageWriter.writeToStream(bitMatrix, "PNG", stream)

    return stream.toByteArray()
}
fun main() {
    embeddedServer(Netty, port = 8080) {
        routing {
            get("/qr") {
                val text = call.request.queryParameters["text"]

                if (text != null) {
                    val imageBytes = generateQRCodeBytes(text)

                    call.response.header(HttpHeaders.ContentType, "image/png")
                    call.respondBytes(imageBytes)
                } else {
                    call.respondText("Missing text parameter")
                }
            }
        }
    }.start(wait = true)
}