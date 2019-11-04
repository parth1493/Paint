package com.farmlead.paint

import android.widget.EditText

fun nullCheckEditTexr(editText: EditText): Boolean {
    if (editText.text.toString().isEmpty()) {
        editText.error = "Please enter value for" + editText.hint.toString()
        return false
    }
    return true
}
fun floodFillUtil(x: Int, y: Int, prevC: Int, newC: Int, canvas:Array<IntArray>):Array<IntArray> {
    try {
        if(canvas[x][y] == newC){
            return canvas
        }
        if (canvas[x][y] == prevC) {

            canvas[x][y] = newC

            floodFillUtil(x + 1, y, prevC, newC,canvas)
            floodFillUtil(x - 1, y - 1, prevC, newC,canvas)
            floodFillUtil(x - 1, y, prevC, newC,canvas)
            floodFillUtil(x - 1, y + 1, prevC, newC,canvas)
            floodFillUtil(x, y + 1, prevC, newC,canvas)
            floodFillUtil(x + 1, y + 1, prevC, newC,canvas)
            floodFillUtil(x, y - 1, prevC, newC,canvas)
            floodFillUtil(x + 1, y - 1, prevC, newC,canvas)
            return canvas
        }else{
            return canvas
        }
    }catch (e: ArrayIndexOutOfBoundsException){
        e.cause
        return canvas
    }catch (e:Exception){
        e.printStackTrace()
        return canvas
    }
}