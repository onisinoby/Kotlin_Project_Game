package com.example.tank_game

import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.Toolbar

class GridDrawer(private val context: Context) {

    private val allLines = mutableListOf<View>()

    fun removeGrid() {
        val container = (context as Activity).findViewById<FrameLayout>(R.id.container)
        allLines.forEach {
            container.removeView(it)
        }
    }

    fun drawGrid(){
        val container = (context as Activity).findViewById<FrameLayout>(R.id.container)
        drawHorizontalLines(container)
        drawVerticalLines(container)
    }

    private fun drawHorizontalLines(container: FrameLayout) {
        var topMargin = 125
        while (topMargin <= container.layoutParams.height){
            val horizontalLine = View(context)
            val layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 4)
            topMargin += CELL_SIZE
            layoutParams.topMargin = topMargin
            horizontalLine.layoutParams = layoutParams
            horizontalLine.setBackgroundColor(context.resources.getColor(android.R.color.white))
            allLines.add(horizontalLine)
            container.addView(horizontalLine)
        }
    }

    private fun drawVerticalLines(container: FrameLayout) {
        var leftMargin = 0
        while (leftMargin <= container.layoutParams.width){
            val verticaltalLine = View(context)
            val layoutParams = FrameLayout.LayoutParams(4, FrameLayout.LayoutParams.WRAP_CONTENT)
            leftMargin += CELL_SIZE
            layoutParams.leftMargin = leftMargin
            verticaltalLine.layoutParams = layoutParams
            verticaltalLine.setBackgroundColor(context.resources.getColor(android.R.color.white))
            allLines.add(verticaltalLine)
            container.addView(verticaltalLine)
        }
    }

}