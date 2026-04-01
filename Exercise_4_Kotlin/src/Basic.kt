import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.client.j2se.MatrixToImageWriter
import java.nio.file.FileSystems
import java.nio.file.Path

fun saveQRCode(content: String, fileName: String) {
    val writer = QRCodeWriter()
    val bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, 300, 300)
    val path: Path = FileSystems.getDefault().getPath(fileName)
    MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path)
}
fun main() {
    saveQRCode("your_email@lehman.cuny.edu", "my_email.png")
}