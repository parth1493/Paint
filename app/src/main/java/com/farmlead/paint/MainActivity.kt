package com.farmlead.paint

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.util.*

/**
 * MainActivity
 * @author Julien Guerinet
 * @since 1.0.0
 */
class MainActivity : AppCompatActivity() {

    /**
     * Number of columns on the canvas, i.e. the 'x' coordinate
     *  Note: Can be changed at compile time
     */
    private val columns = 6

    /**
     * Number of rows on the canvas, i.e. the 'y' coordinate
     *  Note: Can be changed at compile time
     */
    private val rows = 8

    /**
     * Bi-dimensional array representing the pixels on the canvas
     *  Each position in the canvas is a color in Integer format
     */
    private val canvas = Array(columns) { IntArray(rows) }

    /**
     * Different colors that each pixel on the canvas can be
     */
    private val colors = intArrayOf(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayCanvas(initializeCanvas())
    }

    /**
     * Initializes the canvas by creating a random bi-dimensional array of colors
     */
    private fun initializeCanvas(): Array<IntArray> {
        // Create the random object
        val random = Random()

        for (i in 0 until columns) {
            for (j in 0 until rows) {
                // Choose a random number from the list of colors
                canvas[i][j] = colors[random.nextInt(colors.size)]
            }
        }
        return canvas
    }

    /**
     * Displays the canvas on the screen
     */
    private fun displayCanvas(canvas: Array<IntArray>) {
        canvas_grid_view_id.numColumns = columns
        canvas_grid_view_id.numRows = rows
        canvas_grid_view_id.setColor(canvas)
    }

    /**
     * Flood fills the canvas with the new [color], starting at position ([x], [y])
     */
    private fun floodFill(x: Int, y: Int, color: Int) {
        val oldColor = canvas[x][y]
        floodFillUtil(x, y, oldColor, color, canvas)
    }

    fun floodFillOnClick(view: View) {
        val selectedId = color_picker.checkedRadioButtonId
        if (selectedId == -1) {
            Toast.makeText(
                this,
                "No color has been selected",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            val radioButton = color_picker.findViewById<RadioButton>(selectedId)
            val colorCode = radioButton.text.toString()
            if (nullCheckEditTexr(x_coordinate) && nullCheckEditTexr(y_coordinate)) {
                var x_coordinateInt = Integer.parseInt(x_coordinate.text.toString())
                var y_coordinateInt = Integer.parseInt(y_coordinate.text.toString())
                if (x_coordinateInt < 0 || x_coordinateInt >= columns || y_coordinateInt < 0 || y_coordinateInt >= rows) {
                    Toast.makeText(
                        this,
                        "Please select x and y coordinate in range",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } else {
                    doAsync {
                        floodFill(x_coordinateInt, y_coordinateInt, getColorCode(colorCode))

                        uiThread {
                            displayCanvas(canvas)
                        }
                    }
                }
            }
        }
    }

    private fun getColorCode(colorName: String): Int {
        return when (colorName) {
            "Red" -> Color.RED
            "Green" -> Color.GREEN
            "Blue" -> Color.BLUE
            "Yellow" -> Color.YELLOW
            else -> Color.WHITE
        }
    }
}