package com.example.internettest

import android.os.Handler
import android.os.Looper
import android.util.Log
import java.io.IOException
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import okhttp3.*

fun getURLData(myURL: URL){


    val myConnection: HttpURLConnection = myURL.openConnection() as HttpURLConnection
    try {

        val val1 = InputStreamReader(myConnection.inputStream)

        var logString: String

        val1.use {
            logString = it.readText()
        }


        Log.d("sosat", logString)
    }
    catch (e: Exception){
        Log.d("Internet Error", e.toString())
    }
    finally {
        myConnection.disconnect()
    }
}

fun getURLDataOk(url : String) {

    val client = OkHttpClient()

    val request : Request = Request.Builder()
        .url(url)
        .build()

    client.newCall(request).enqueue(object: Callback {
        override fun onFailure(call: Call, e: IOException) {
            e.printStackTrace()
        }

        override fun onResponse(call: Call, response: Response) {
            response.use {
                if (!response.isSuccessful) throw IOException("Unexpected code $response")
                Log.i("Flickr OkCats: ", response.body?.string().toString())
            }

        }
    })
}