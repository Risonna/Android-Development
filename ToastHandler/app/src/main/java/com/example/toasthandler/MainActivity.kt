package com.example.toasthandler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonOk: Button = findViewById(R.id.button_ok)
        buttonOk.apply{
        }
        var r = 0
        buttonOk.setOnClickListener(){
            val textOK = "Кнопка OK"
            buttonOk.setText(textOK+r)
            Toast.makeText(applicationContext, textOK, Toast.LENGTH_SHORT).show()
            r = r+1
        }


    }

    fun createToast(view: View){

    }
}