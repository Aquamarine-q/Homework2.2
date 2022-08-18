package com.example.counterhomework

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var mCount = 0
    private lateinit var counterText: TextView
    private lateinit var someText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        someText = findViewById(R.id.some_text)
        counterText = findViewById(R.id.counter_text)

        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt("counter")
            counterText.text = savedInstanceState.getString("counter_text")
            someText.setText(savedInstanceState.getString("some_text"))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter", mCount)
        outState.putString("counter_text", counterText.text.toString())
        outState.putString("some_text", someText.text.toString())
    }

    fun countUp(view: View) {
        mCount++
        counterText.text = mCount.toString()
    }
}