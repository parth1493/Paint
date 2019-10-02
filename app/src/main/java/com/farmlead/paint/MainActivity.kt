package com.farmlead.paint

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        initializeCanvas()
        displayCanvas()
    }

    /**
     * Initializes the canvas by creating a random bi-dimensional array of colors
     */
    private fun initializeCanvas() {
        // Create the random object
        val random = Random()

        for (i in 0 until columns) {
            for (j in 0 until rows) {
                // Choose a random number from the list of colors
                canvas[i][j] = colors[random.nextInt(colors.size)]
            }
        }
    }

    /**
     * Displays the canvas on the screen
     */
    private fun displayCanvas() {
        // TODO
    }

    /**
     * Flood fills the canvas with the new [color], starting at position ([x], [y])
     */
    private fun floodFill(x: Int, y: Int, color: Int) {
        // TODO
    }
}