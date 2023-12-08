package com.example.newactivity

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

        val btn = findViewById<Button>(R.id.btn_show_pic)

        btn.setOnClickListener {
            this.sendMessage()
        }
    }

    public fun sendMessage(){
        val intent = Intent(this, PicActivity::class.java)
        //val img = findViewById<ImageView>(R.id.picView)

        val url = "https://img5.goodfon.ru/original/800x480/f/22/kosmos-prostranstvo-planety-tumannost-art.jpg"
        intent.putExtra("picLink", url)
        startActivity(intent)

        Timber.d("TEST1")
    }
}