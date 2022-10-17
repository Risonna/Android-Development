package com.example.internettest

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnHTTPsomehow: Button = findViewById(R.id.btnHTTP)

        btnHTTPsomehow.setOnClickListener{


            val myURL = "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=ff49fcd4d4a08aa6aafb6ea3de826464&tags=cat&format=json&nojsoncallback=1"
            Thread{
               getURLData(URL(myURL))
                }.start()
        }

        val btnOkHTTPsomehow: Button = findViewById(R.id.btnOkHTTP)

        btnOkHTTPsomehow.setOnClickListener{

            val myURL = "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=ff49fcd4d4a08aa6aafb6ea3de826464&tags=cat&format=json&nojsoncallback=1"
            Thread{
                getURLDataOk(myURL)
            }.start()
        }

    }



}
