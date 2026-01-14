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

object NeonRenderer : WordImageRenderer() {
    override val name: Int
        get() = R.string.action_fonttyper_preset_title_neon

    override fun renderLine(
        context: Context,
        text: String
    ): LineRenderResult? {
        val neonColor = 0xFF00FFFF.toInt()
        val glowColor = 0xFF0080FF.toInt()
        val backgroundColor = 0xFF000000.toInt()

        val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            textSize = 64f
            textAlign = Paint.Align.LEFT
            typeface = Typeface.create("sans-serif", Typeface.BOLD)
            color = neonColor
        }

        val bounds = Rect()
        paint.getTextBounds(text, 0, text.length, bounds)

        val bitmap = createBitmap(bounds.width() + 40, bounds.height() + 40)
        val canvas = Canvas(bitmap)

        // Draw dark background
        canvas.drawColor(backgroundColor)

        val xOffs = 20f
        val yOffs = (bounds.height().toFloat() + 40f) / 2.0f + 10f

        // Draw glow effect
        paint.color = glowColor
        paint.alpha = 100
        paint.strokeWidth = 8f
        paint.style = Paint.Style.STROKE
        canvas.drawText(text, xOffs, yOffs, paint)

        // Draw main neon text
        paint.color = neonColor
        paint.alpha = 255
        paint.strokeWidth = 2f
        paint.style = Paint.Style.STROKE
        canvas.drawText(text, xOffs, yOffs, paint)

        // Fill the text
        paint.style = Paint.Style.FILL
        canvas.drawText(text, xOffs, yOffs, paint)

        return LineRenderResult(
            bitmap = bitmap,
            lineHeight = 64,
            startXOffset = 20,
            startYOffset = yOffs.toInt()
        )
    }
}

@Preview
@Composable
private fun PreviewRenderer() {
    val context = LocalContext.current
    val renderer = NeonRenderer
    val image = remember {
        renderer.render(context, context.getString(renderer.name))!!.asImageBitmap()
    }
    Image(image, contentDescription = null)
}
