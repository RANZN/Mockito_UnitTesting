package com.ranzn.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val a = Calculator().add(10, 20)
        Log.d(Companion.TAG, "onCreate: $a")

        println(a)
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}