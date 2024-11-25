package com.example.tank_game


import androidx.appcompat.widget.Toolbar
import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.*
import android.widget.FrameLayout
import android.view.Menu
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

const val CELL_SIZE = 25
const val VERTICAL_CELL_AMOUNT = 89
const val HORIZONTAL_CELL_AMOUNT = 38
const val VERTICAL_MAX_SIZE = CELL_SIZE * VERTICAL_CELL_AMOUNT
const val HORIZONTAL_MAX_SIZE = CELL_SIZE * HORIZONTAL_CELL_AMOUNT

class MainActivity : AppCompatActivity() {
    private var editMode = false

    private val gridDrawer by lazy {
        GridDrawer(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val container: FrameLayout = findViewById(R.id.container)
        container.layoutParams = FrameLayout.LayoutParams(VERTICAL_MAX_SIZE, HORIZONTAL_MAX_SIZE)

        val mctank: ImageView = findViewById(R.id.myTank)
        val layoutParams = mctank.layoutParams as FrameLayout.LayoutParams
        (mctank.layoutParams as FrameLayout.LayoutParams).topMargin += 125
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.settings, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_settings -> {
                switchEditMode()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun switchEditMode() {
        val materials_container: LinearLayout = findViewById(R.id.materials_container)
        if (editMode) {
            gridDrawer.removeGrid()
            materials_container.visibility = GONE
        } else {
            gridDrawer.drawGrid()
            materials_container.visibility = VISIBLE
        }
        editMode = !editMode
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
        val mctank: ImageView = findViewById(R.id.myTank)
        val layoutParams = mctank.layoutParams as FrameLayout.LayoutParams
        val container: FrameLayout = findViewById(R.id.container)
        when (direction) {
            Direction.UP -> {
                mctank.rotation = 0f
                if (layoutParams.topMargin > 125) {
                    (mctank.layoutParams as FrameLayout.LayoutParams).topMargin += -CELL_SIZE
                }
            }
            Direction.BOTTOM -> {
                mctank.rotation = 180f
                if (layoutParams.topMargin + mctank.height < HORIZONTAL_MAX_SIZE) {
                    (mctank.layoutParams as FrameLayout.LayoutParams).topMargin += CELL_SIZE
                }
            }
            Direction.RIGHT -> {
                mctank.rotation = 90f
                if (layoutParams.leftMargin + mctank.width < VERTICAL_MAX_SIZE) {
                    (mctank.layoutParams as FrameLayout.LayoutParams).leftMargin += CELL_SIZE
                }
            }
            Direction.LEFT -> {
                mctank.rotation = 270f
                if (layoutParams.leftMargin > 0) {
                    (mctank.layoutParams as FrameLayout.LayoutParams).leftMargin += -CELL_SIZE
                }
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