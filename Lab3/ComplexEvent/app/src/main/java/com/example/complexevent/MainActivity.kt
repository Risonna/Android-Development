package com.example.complexevent

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView1: TextView = findViewById(R.id.textView)
        var PRSbar: ProgressBar = findViewById(R.id.PRSbar)
        var button1: Button = findViewById(R.id.button)
        var editText1: EditText = findViewById(R.id.editText)
        var checkBox1: CheckBox = findViewById(R.id.checkBox)

        button1.setOnClickListener{
            if (checkBox1.isChecked) {
                textView1.setText(editText1.text.toString())
            }
            PRSbar.incrementProgressBy(10)
        }


    }
}