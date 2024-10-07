package com.example.tank_game


import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.*
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KEYCODE_DPAD_UP -> move(Direction.UP)
            KEYCODE_DPAD_LEFT -> move(Direction.LEFT)
            KEYCODE_DPAD_DOWN -> move(Direction.BOTTOM)
            KEYCODE_DPAD_RIGHT -> move(Direction.RIGHT)
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun move(direction: Direction) {
        val mctank: ImageView = findViewById(R.id.mctank)
        val container: FrameLayout = findViewById(R.id.main)
        when (direction) {
            Direction.UP -> {
                mctank.rotation = 0f
                (mctank.layoutParams as FrameLayout.LayoutParams).topMargin += -50
            }
            Direction.BOTTOM -> {
                mctank.rotation = 180f
                (mctank.layoutParams as FrameLayout.LayoutParams).topMargin += 50
            }
            Direction.RIGHT -> {
                mctank.rotation = 90f
                (mctank.layoutParams as FrameLayout.LayoutParams).leftMargin += 50
            }
            Direction.LEFT -> {
                mctank.rotation = 270f
                (mctank.layoutParams as FrameLayout.LayoutParams).leftMargin += -50
            }

            Direction.UP -> TODO()
            Direction.RIGHT -> TODO()
            Direction.LEFT -> TODO()
            Direction.BOTTOM -> TODO()
        }
        container.removeView(mctank)
        container.addView(mctank)
    }
}