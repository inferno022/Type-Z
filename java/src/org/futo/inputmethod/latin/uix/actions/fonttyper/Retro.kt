package org.futo.inputmethod.latin.uix.actions.fonttyper

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
import org.futo.inputmethod.latin.R

object RetroRenderer : WordImageRenderer() {
    override val name: Int
        get() = R.string.action_fonttyper_preset_title_retro

    override fun renderLine(
        context: Context,
        text: String
    ): LineRenderResult? {
        val textColor = 0xFFFF6B35.toInt()
        val shadowColor = 0xFF8B4513.toInt()
        val backgroundColor = 0xFFFFE4B5.toInt()

        val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            textSize = 60f
            textAlign = Paint.Align.LEFT
            typeface = try {
                Typeface.createFromAsset(context.assets, "fonts/Anton-Regular.ttf")
            } catch (e: Exception) {
                // Fallback to system font if custom font fails to load
                Typeface.create("sans-serif", Typeface.BOLD)
            }
            color = textColor
        }

        val bounds = Rect()
        paint.getTextBounds(text, 0, text.length, bounds)

        val bitmap = createBitmap(bounds.width() + 40, bounds.height() + 40)
        val canvas = Canvas(bitmap)

        // Draw retro background
        canvas.drawColor(backgroundColor)

        val xOffs = 20f
        val yOffs = (bounds.height().toFloat() + 40f) / 2.0f + 10f

        // Draw shadow
        paint.color = shadowColor
        canvas.drawText(text, xOffs + 2f, yOffs + 2f, paint)

        // Draw main text
        paint.color = textColor
        canvas.drawText(text, xOffs, yOffs, paint)

        return LineRenderResult(
            bitmap = bitmap,
            lineHeight = 60,
            startXOffset = 20,
            startYOffset = yOffs.toInt()
        )
    }
}

@Preview
@Composable
private fun PreviewRenderer() {
    val context = LocalContext.current
    val renderer = RetroRenderer
    val image = remember {
        renderer.render(context, context.getString(renderer.name))!!.asImageBitmap()
    }
    Image(image, contentDescription = null)
}
