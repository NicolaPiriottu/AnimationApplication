package com.example.animationapplication

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


class MainActivity : AppCompatActivity() {

    private var isClicked = false
    private lateinit var text: TextView
    private lateinit var container:ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       text = findViewById<TextView>(R.id.myAnimation)
        container = findViewById<ConstraintLayout>(R.id.container)


        text.setOnClickListener {
            isClicked = if (!isClicked) {
                text.animate().translationX(container.width.toFloat() - text.width.toFloat())
                !isClicked
            } else {
                text.animate().translationX(0F)
                !isClicked
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d("niko", "dentro onTouchEvent : ${event}")
        when (event?.action) {
            MotionEvent.ACTION_MOVE -> {

                text.animate().translationX(event.x - text.width.toFloat())

                Log.d("niko", "mi stai trascinando")

            }
        }
        return true
    }
}