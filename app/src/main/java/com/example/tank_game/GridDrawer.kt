package com.example.tank_game

import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.Toolbar

class GridDrawer(private val context: Context) {
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
            container.addView(horizontalLine)
        }
    }

    private fun drawVerticalLines(container: FrameLayout) {
        var leftMargin = 0
        while (leftMargin <= container.layoutParams.width){
            val horizontalLine = View(context)
            val layoutParams = FrameLayout.LayoutParams(4, FrameLayout.LayoutParams.WRAP_CONTENT)
            leftMargin += CELL_SIZE
            layoutParams.leftMargin = leftMargin
            horizontalLine.layoutParams = layoutParams
            horizontalLine.setBackgroundColor(context.resources.getColor(android.R.color.white))
            container.addView(horizontalLine)
        }
    }

}