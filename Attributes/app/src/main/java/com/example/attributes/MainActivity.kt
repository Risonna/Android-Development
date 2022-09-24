package com.example.attributes

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var uselessTextEdit: EditText = findViewById(R.id.textEditSomething);

        var buttonMakeBlackText: Button = findViewById(R.id.blackTextButton);
        buttonMakeBlackText.setOnClickListener(){
            uselessTextEdit.setTextColor(Color.BLACK)
        }

        var buttonMakeRedText: Button = findViewById(R.id.redTextButton);
        buttonMakeRedText.setOnClickListener(){
            uselessTextEdit.setTextColor(Color.RED)
        }

        var buttonMake8SPText: Button = findViewById(R.id.size8SPButton);
        buttonMake8SPText.setOnClickListener(){
            uselessTextEdit.setTextSize(TypedValue.COMPLEX_UNIT_SP, 8.toFloat())
        }

        var buttonMake24SPText: Button = findViewById(R.id.razmer24SP)
        buttonMake24SPText.setOnClickListener(){
            uselessTextEdit.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24.toFloat())
        }

        var buttonMakeWhiteBackground: Button = findViewById(R.id.whiteBackground)
        buttonMakeWhiteBackground.setOnClickListener(){
            uselessTextEdit.setBackgroundColor(Color.WHITE)
        }

        var buttonMakeYellowBackground: Button = findViewById(R.id.yellowBackground)
        buttonMakeYellowBackground.setOnClickListener(){
            uselessTextEdit.setBackgroundColor(Color.YELLOW)
        }
    }
}