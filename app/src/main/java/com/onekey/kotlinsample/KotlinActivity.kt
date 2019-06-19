package com.onekey.kotlinsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.onekey.kotlinsample.entity.PrimaryStudent
import com.onekey.kotlinsample.tools.MathTool

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        MathTool.reduce(10, 5);

        var student = PrimaryStudent("Amry")
    }
}
