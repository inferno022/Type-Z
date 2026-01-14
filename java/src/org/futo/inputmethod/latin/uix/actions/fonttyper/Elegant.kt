package com.typez.keyboard.app.uix.actions.fonttyper

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.Typeface
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.graphics.createBitmap
import com.typez.keyboard.app.R

object ElegantRenderer : WordImageRenderer() {
    override val name: Int
        get() = R.string.action_fonttyper_preset_title_elegant

    override fun renderLine(
        context: Context,
        text: String
    ): LineRenderResult? {
        val textColor = 0xFF2C3E50.toInt()
        val accentColor = 0xFFE74C3C.toInt()
        val backgroundColor = 0xFFECF0F1.toInt()

        val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            textSize = 58f
            textAlign = Paint.Align.LEFT
            typeface = Typeface.create("serif", Typeface.ITALIC)
            color = textColor
        }

        val bounds = Rect()
        paint.getTextBounds(text, 0, text.length, bounds)

        val bitmap = createBitmap(bounds.width() + 40, bounds.height() + 40)
        val canvas = Canvas(bitmap)

        // Draw elegant background
        canvas.drawColor(backgroundColor)

        val xOffs = 20f
        val yOffs = (bounds.height().toFloat() + 40f) / 2.0f + 10f

        // Draw main text
        canvas.drawText(text, xOffs, yOffs, paint)

        // Add elegant underline
        paint.color = accentColor
        paint.strokeWidth = 2f
        paint.style = Paint.Style.STROKE
        canvas.drawLine(xOffs, yOffs + 8f, xOffs + bounds.width(), yOffs + 8f, paint)

        return LineRenderResult(
            bitmap = bitmap,
            lineHeight = 58,
            startXOffset = 20,
            startYOffset = yOffs.toInt()
        )
    }
}

@Preview
@Composable
private fun PreviewRenderer() {
    val context = LocalContext.current
    val renderer = ElegantRenderer
    val image = remember {
        renderer.render(context, context.getString(renderer.name))!!.asImageBitmap()
    }
    Image(image, contentDescription = null)
}
