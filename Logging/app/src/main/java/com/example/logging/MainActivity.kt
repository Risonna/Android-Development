package com.example.logging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        var buttonLog: Button = findViewById(R.id.button_log);
        var texteditgospodi: EditText = findViewById(R.id.editMaybe);
        buttonLog.setOnClickListener(){
            val textLog = "from EditText"
            Log.i(textLog, texteditgospodi.text.toString());
        }

        var buttonTimber: Button = findViewById(R.id.button_timber);
        buttonTimber.setOnClickListener(){
            Timber.v(texteditgospodi.text.toString())
        }
    }


}
