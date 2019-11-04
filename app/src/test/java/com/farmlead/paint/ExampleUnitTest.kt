package com.farmlead.paint

import android.graphics.Color

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private val columns = 4
    private val rows = 4
    private val expectedCanvas = Array(columns) { IntArray(rows) }
    private val canvas = Array(columns) { IntArray(rows) }

    @BeforeEach
    fun init(){
        canvas[0][0] = Color.GREEN
        canvas[0][1] = Color.YELLOW
        canvas[0][2] = Color.RED
        canvas[0][3] = Color.BLUE
        canvas[1][0] = Color.YELLOW
        canvas[1][1] = Color.GREEN
        canvas[1][2] = Color.BLUE
        canvas[1][3] = Color.RED
        canvas[2][0] = Color.GREEN
        canvas[2][1] = Color.BLUE
        canvas[2][2] = Color.RED
        canvas[2][3] = Color.YELLOW
        canvas[3][0] = Color.BLUE
        canvas[3][1] = Color.GREEN
        canvas[3][2] = Color.YELLOW
        canvas[3][3] = Color.RED

        expectedCanvas[0][0] = Color.GREEN
        expectedCanvas[0][1] = Color.YELLOW
        expectedCanvas[0][2] = Color.RED
        expectedCanvas[0][3] = Color.RED
        expectedCanvas[1][0] = Color.YELLOW
        expectedCanvas[1][1] = Color.GREEN
        expectedCanvas[1][2] = Color.RED
        expectedCanvas[1][3] = Color.RED
        expectedCanvas[2][0] = Color.GREEN
        expectedCanvas[2][1] = Color.RED
        expectedCanvas[2][2] = Color.RED
        expectedCanvas[2][3] = Color.YELLOW
        expectedCanvas[3][0] = Color.RED
        expectedCanvas[3][1] = Color.GREEN
        expectedCanvas[3][2] = Color.YELLOW
        expectedCanvas[3][3] = Color.RED
    }

    @DisplayName("Test Flood fill Algorithm")
    @org.junit.jupiter.api.Test
    fun validate_bi_dimensional_array(){

        val canvas = floodFillUtil(1,2, Color.BLUE, Color.RED,canvas)
        Assertions.assertArrayEquals(expectedCanvas,canvas,"Its done")
    }
}
