package com.example.newactivity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import timber.log.Timber


class PicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pic)
        Timber.plant(Timber.DebugTree())

        val intent = getIntent()
        val message = intent.getStringExtra("picLink")

        val imageView = findViewById<ImageView>(R.id.picView)
        Glide
            .with(this)
            .load(message)
            .into(imageView)

        Timber.d("TEST:\t" + message)
    }
}