package com.example

import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import java.util.Base64
import javax.imageio.ImageIO

class QrUtils {

    companion object {

        fun generateQrBase64(data: String): String {
            val bitMatrix: BitMatrix = MultiFormatWriter().encode(
                data,
                BarcodeFormat.QR_CODE,
                250,
                250
            )

            val width = bitMatrix.width
            val height = bitMatrix.height
            val image = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)

            for (x in 0 until width) {
                for (y in 0 until height) {
                    image.setRGB(
                        x,
                        y,
                        if (bitMatrix[x, y]) 0xFF000000.toInt()
                        else 0xFFFFFFFF.toInt()
                    )
                }
            }

            val outputStream = ByteArrayOutputStream()
            ImageIO.write(image, "PNG", outputStream)

            return Base64.getEncoder().encodeToString(outputStream.toByteArray())
        }
    }
}