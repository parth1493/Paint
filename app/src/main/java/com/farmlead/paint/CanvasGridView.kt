package com.farmlead.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CanvasGridView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    var numColumns: Int = 0
        set(numColumns) {
            field = numColumns
            calculateDimensions()
        }
    var numRows: Int = 0
        set(numRows) {
            field = numRows
            calculateDimensions()
        }
    private var cellWidth: Float = 0.0f
    private var cellHeight: Float = 0.0f
    private val mPaint = Paint()
    private var canvasArray: Array<IntArray>? = null

    fun setColor(canvas: Array<IntArray>) {
        this.canvasArray = canvas
        calculateDimensions()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        calculateDimensions()
    }

    private fun calculateDimensions() {
        if (this.numColumns < 1 || this.numRows < 1) {
            return
        }
        cellWidth = (width.toDouble() / numColumns).toFloat()
        cellHeight = (height.toDouble() / numRows).toFloat()
        invalidate()
    }

    fun setPaint(colorCode: Int): Paint {
        mPaint.color = colorCode
        return mPaint
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawColor(Color.WHITE)

        if (this.numColumns == 0 || this.numRows == 0) {
            return
        }
        for (i in 0 until this.numColumns) {
            for (j in 0 until this.numRows) {
                canvas.drawRect((i * cellWidth).toFloat(), (j * cellHeight).toFloat(),
                        ((i + 1) * cellWidth).toFloat(), ((j + 1) * cellHeight).toFloat(),
                        setPaint(canvasArray!![i][j]))
            }
        }
    }
}
